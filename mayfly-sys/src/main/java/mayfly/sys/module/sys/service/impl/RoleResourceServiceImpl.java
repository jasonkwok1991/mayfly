package mayfly.sys.module.sys.service.impl;

import mayfly.core.base.service.impl.BaseServiceImpl;
import mayfly.core.exception.BusinessAssert;
import mayfly.core.util.CollectionUtils;
import mayfly.core.util.TreeUtils;
import mayfly.sys.module.sys.controller.vo.RoleResourceVO;
import mayfly.sys.module.sys.entity.RoleResourceDO;
import mayfly.sys.module.sys.mapper.RoleResourceMapper;
import mayfly.sys.module.sys.service.PermissionService;
import mayfly.sys.module.sys.service.ResourceService;
import mayfly.sys.module.sys.service.RoleResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author meilin.huang
 * @version 1.0
 * @date 2019-06-30 11:59
 */
@Service
public class RoleResourceServiceImpl extends BaseServiceImpl<RoleResourceMapper, Integer, RoleResourceDO> implements RoleResourceService {

    @Autowired
    private RoleResourceMapper roleResourceMapper;
    @Autowired
    private PermissionService permissionService;
    @Autowired
    private ResourceService resourceService;

    @Override
    public List<Integer> listResourceId(Integer roleId) {
        RoleResourceDO condition = new RoleResourceDO().setRoleId(roleId);
        return listByCondition(condition).stream().map(RoleResourceDO::getResourceId).collect(Collectors.toList());
    }

    @Override
    public List<RoleResourceVO> listResource(Integer roleId) {
        return TreeUtils.generateTrees(roleResourceMapper.selectResourceByRoleId(roleId));
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveResource(Integer roleId, List<Integer> resourceIds) {
        List<Integer> oldIds = listResourceId(roleId);
        //和之前存的权限列表id比较，哪些是新增已经哪些是修改以及不变的
        CollectionUtils.CompareResult<Integer> compareResult = CollectionUtils
                .compare(resourceIds, oldIds, (Integer i1, Integer i2) -> i1.equals(i2) ? 0 : 1);
        Collection<Integer> delIds = compareResult.getDelValue();
        Collection<Integer> addIds = compareResult.getAddValue();

        // 删除去除的资源id
        delIds.forEach(id -> {
            deleteByCondition(new RoleResourceDO()
                    .setRoleId(roleId).setResourceId(id));
        });

        // 校验资源id正确性，及保存新增的资源id
        BusinessAssert.equals(resourceService.listByIdIn((List<Integer>) addIds).size(), addIds.size(), "资源id错误");
        List<RoleResourceDO> addValues = new ArrayList<>(addIds.size());
        for (Integer id : addIds) {
            RoleResourceDO rr = new RoleResourceDO().setRoleId(roleId).setResourceId(id);
            rr.autoSetBaseInfo();
            addValues.add(rr);
        }
        batchInsert(addValues);
    }
}
