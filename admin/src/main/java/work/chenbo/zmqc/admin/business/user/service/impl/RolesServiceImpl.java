package work.chenbo.zmqc.admin.business.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.chenbo.zmqc.admin.business.user.entity.RolePermission;
import work.chenbo.zmqc.admin.business.user.entity.Roles;
import work.chenbo.zmqc.admin.business.user.entity.UserRole;
import work.chenbo.zmqc.admin.business.user.manager.RolesManager;
import work.chenbo.zmqc.admin.business.user.service.RolesService;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @className RolesServiceImpl
 * @authtor ChenBo
 * @date 2020/4/3
 */
@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    private RolesManager rolesManager;

    /**
     * 根据权限ID查询可以访问角色列表
     *
     * @param permissionId
     * @author; ChenBo
     * @datetime: 2020/4/3
     */
    @Override
    public List<Roles> queryRolesByPermission(Integer permissionId) {
        List<RolePermission> rolePermissionList = rolesManager.selectRolePermissionByPermissionId(permissionId);
        return rolePermissionList.stream().filter(Objects::nonNull)
                .map(RolePermission::getRoleId)
                .map(id -> rolesManager.selectRoleById(id)).collect(Collectors.toList());
    }

    /**
     * 根据用户ID查询用户所具有的角色
     *
     * @param userId
     * @author; ChenBo
     * @datetime: 2020/4/3
     */
    @Override
    public List<Roles> queryRolesByUser(Integer userId) {
        List<UserRole> userRoleList =  rolesManager.selectUserRoleListByUserId(userId);
       return userRoleList.stream().filter(Objects::nonNull)
               .map(UserRole::getRoleId)
               .map(id -> rolesManager.selectRoleById(id)).collect(Collectors.toList());
    }
}
