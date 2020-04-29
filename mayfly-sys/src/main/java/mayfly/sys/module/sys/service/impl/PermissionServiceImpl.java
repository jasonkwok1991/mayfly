package mayfly.sys.module.sys.service.impl;

import mayfly.core.permission.LoginAccount;
import mayfly.core.permission.registry.LoginAccountRegistryHandler;
import mayfly.core.util.BracePlaceholder;
import mayfly.core.util.StringUtils;
import mayfly.core.util.TreeUtils;
import mayfly.core.util.UUIDUtils;
import mayfly.core.util.bean.BeanUtils;
import mayfly.sys.common.cache.CacheKey;
import mayfly.sys.common.enums.EnableDisableEnum;
import mayfly.sys.module.sys.controller.vo.AccountVO;
import mayfly.sys.module.sys.controller.vo.LoginSuccessVO;
import mayfly.sys.module.sys.controller.vo.ResourceListVO;
import mayfly.sys.module.sys.entity.AccountDO;
import mayfly.sys.module.sys.enums.ResourceTypeEnum;
import mayfly.sys.module.sys.service.PermissionService;
import mayfly.sys.module.sys.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * 权限服务实现类
 *
 * @author hml
 * @date 2018/6/26 上午9:49
 */
@Service
public class PermissionServiceImpl implements PermissionService  {

    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private ResourceService resourceService;

    /**
     * 权限缓存处理器
     */
    private final LoginAccountRegistryHandler<Long> loginAccountRegistryHandler = LoginAccountRegistryHandler.of(this);


    @Override
    public LoginSuccessVO saveIdAndPermission(AccountDO account) {
        Long id = account.getId();
        String token = UUIDUtils.generateUUID();
        List<ResourceListVO> resources = resourceService.listByAccountId(id);
        // 菜单列表
        List<ResourceListVO> menus = new ArrayList<>();
        // 含有权限code的列表
        List<ResourceListVO> codes = new ArrayList<>();
        for (ResourceListVO r : resources) {
            if (!StringUtils.isEmpty(r.getCode())) {
                codes.add(r);
            }
            if (Objects.equals(r.getType(), ResourceTypeEnum.MENU.getValue())) {
                menus.add(r);
            }
        }

        // 获取所有含有权限code的资源，如果权限被禁用，将会在code后加上:0标志，用于保存服务端进行校验
        List<String> permissionCodes = codes.stream().map(p -> p.getStatus().equals(EnableDisableEnum.DISABLE.getValue()) ?
                LoginAccount.getDisablePermissionCode(p.getCode()) : p.getCode()).collect(Collectors.toList());
        // 保存登录账号信息
        LoginAccount<Long> loginAccount = new LoginAccount<Long>().setId(account.getId()).setUsername(account.getUsername())
                .setPermissions(permissionCodes);
        loginAccountRegistryHandler.saveLoginAccount(token, loginAccount, CacheKey.SESSION_EXPIRE_TIME, TimeUnit.MINUTES);

        return LoginSuccessVO.builder().admin(BeanUtils.copyProperties(account, AccountVO.class))
                .token(token).menus(TreeUtils.generateTrees(menus)).codes(codes).build();
    }

    @Override
    public void removeToken(String token) {
        loginAccountRegistryHandler.removeLoginAccount(token);
    }


    //------------------------------------------------------------
    //  LoginAccountRegistry  接口实现类
    //------------------------------------------------------------

    @SuppressWarnings("all")
    @Override
    public void save(String token, LoginAccount loginAccount, long time, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(BracePlaceholder.resolveByObject(CacheKey.ACCOUNT_TOKEN_KEY, token), loginAccount, time, timeUnit);
    }

    @SuppressWarnings("all")
    @Override
    public LoginAccount<Long> getLoginAccount(String token) {
        return (LoginAccount<Long>) redisTemplate.opsForValue().get(BracePlaceholder.resolveByObject(CacheKey.ACCOUNT_TOKEN_KEY, token));
    }

    @SuppressWarnings("all")
    @Override
    public void delete(String token) {
        redisTemplate.delete(BracePlaceholder.resolveByObject(CacheKey.ACCOUNT_TOKEN_KEY, token));
    }
}
