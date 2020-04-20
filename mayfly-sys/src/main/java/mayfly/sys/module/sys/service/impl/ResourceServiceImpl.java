package mayfly.sys.module.sys.service.impl;

import mayfly.core.base.service.impl.BaseServiceImpl;
import mayfly.core.exception.BusinessAssert;
import mayfly.core.log.MethodLog;
import mayfly.core.util.StringUtils;
import mayfly.core.util.TreeUtils;
import mayfly.core.util.bean.BeanUtils;
import mayfly.core.util.enums.EnumUtils;
import mayfly.sys.common.enums.EnableDisableEnum;
import mayfly.sys.module.sys.controller.vo.ResourceListVO;
import mayfly.sys.module.sys.entity.ResourceDO;
import mayfly.sys.module.sys.entity.RoleResourceDO;
import mayfly.sys.module.sys.enums.ResourceTypeEnum;
import mayfly.sys.module.sys.mapper.ResourceMapper;
import mayfly.sys.module.sys.service.OperationLogService;
import mayfly.sys.module.sys.service.PermissionService;
import mayfly.sys.module.sys.service.ResourceService;
import mayfly.sys.module.sys.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 菜单实现类
 *
 * @author hml
 * @date 2018/6/27 下午4:09
 */
@MethodLog("资源管理:")
@Service
public class ResourceServiceImpl extends BaseServiceImpl<ResourceMapper, Long, ResourceDO> implements ResourceService {

    @Autowired
    private RoleResourceService roleResourceService;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private OperationLogService operationLogService;

    @MethodLog(level = MethodLog.LogLevel.NONE)
    @Override
    public List<ResourceListVO> listByAccountId(Long userId) {
        return BeanUtils.copyProperties(mapper.selectByAccountId(userId), ResourceListVO.class);
    }

    @MethodLog(value = "获取资源树", level = MethodLog.LogLevel.DEBUG)
    @Override
    public List<ResourceListVO> listResource() {
        return TreeUtils.generateTrees(BeanUtils.copyProperties(listAll("pid ASC, weight ASC"),
                ResourceListVO.class));
    }

    @Override
    public void create(ResourceDO resource) {
        if (resource.getPid() == null || Objects.equals(resource.getPid(), 0L)) {
            BusinessAssert.equals(resource.getType(), ResourceTypeEnum.MENU.getValue(), "权限资源不能为根节点");
            // 为null的情况默认设为0
            resource.setPid(0L);
        } else {
            ResourceDO pResource = getById(resource.getPid());
            BusinessAssert.notNull(pResource, "pid不存在！");
            BusinessAssert.equals(pResource.getType(), ResourceTypeEnum.MENU.getValue(), "权限资源不能添加子节点");
        }
        String code = resource.getCode();
        // 如果是添加菜单，则该父节点不能存在有权限节点
        if (Objects.equals(resource.getType(), ResourceTypeEnum.MENU.getValue())) {
            // 查询指定pid节点下是否有权限节点
            BusinessAssert.equals(countByCondition(new ResourceDO().setPid(resource.getPid()).setType(ResourceTypeEnum.PERMISSION.getValue()))
                    , 0L, "该菜单下已有权限资源子节点，不能再添加菜单");
            if (!StringUtils.isEmpty(code)) {
                checkPermissionCode(code);
            }
        } else {
            BusinessAssert.notEmpty(code, "权限code不能为空");
            checkPermissionCode(code);
        }
        //默认启用
        resource.setStatus(EnableDisableEnum.ENABLE.getValue());
        insert(resource);
    }

    @Override
    public void update(ResourceDO resource) {
        ResourceDO old = getById(resource.getId());
        BusinessAssert.notNull(old, "资源不存在");
        BusinessAssert.equals(resource.getType(), old.getType(), "资源类型不可变更");
        // 禁止误传修改其父节点
        resource.setPid(null);

        String code = resource.getCode();
        // 如果修改了权限code，则需要校验
        if (!Objects.equals(old.getCode(), code)) {
            // 如果是权限，还需校验非空
            if (Objects.equals(old.getType(), ResourceTypeEnum.PERMISSION.getValue())) {
                BusinessAssert.notEmpty(code, "权限code不能为空");
                checkPermissionCode(code);
            } else {
                if (!StringUtils.isEmpty(code)) {
                    checkPermissionCode(code);
                }
            }
        }
        updateByIdSelective(resource);
        operationLogService.asyncUpdateLog("更新权限&菜单", resource, old);
    }

    @Override
    public void changeStatus(Long id, Integer status) {
        BusinessAssert.state(EnumUtils.isExist(EnableDisableEnum.values(), status), "状态值错误");
        ResourceDO resource = getById(id);
        BusinessAssert.notNull(resource, "该资源不存在");
        // 状态不变直接返回
        if (Objects.equals(status, resource.getStatus())) {
            return;
        }
        resource.setStatus(status);
        // 更新数据库状态
        updateByIdSelective(resource);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(Long id) {
        BusinessAssert.equals(countByCondition(new ResourceDO().setPid(id)), 0L, "请先删除该资源的子资源");
        BusinessAssert.equals(deleteById(id), 1, "删除菜单失败！");
        // 删除角色资源表中该菜单所关联的所有信息
        roleResourceService.deleteByCondition(new RoleResourceDO().setResourceId(id));
    }

    /**
     * 校验权限code
     *
     * @param code code
     */
    private void checkPermissionCode(String code) {
        BusinessAssert.state(!code.contains(","), "权限code不能包含','");
        BusinessAssert.equals(countByCondition(new ResourceDO().setCode(code)), 0L, "该权限code已存在");
    }
}
