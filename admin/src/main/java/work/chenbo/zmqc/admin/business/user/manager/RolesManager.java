package work.chenbo.zmqc.admin.business.user.manager;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import work.chenbo.zmqc.admin.business.user.entity.RolePermission;
import work.chenbo.zmqc.admin.business.user.entity.Roles;
import work.chenbo.zmqc.admin.business.user.entity.UserRole;
import work.chenbo.zmqc.admin.business.user.mapper.RolePermissionMapper;
import work.chenbo.zmqc.admin.business.user.mapper.RolesMapper;
import work.chenbo.zmqc.admin.business.user.mapper.UserRoleMapper;

import java.util.List;

/**
 * @className RolesManager
 * @authtor ChenBo
 * @date 2020/4/3
 */
@Service
public class RolesManager {

    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private RolesMapper rolesMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    /**
    * 根据用户Id查询角色ID
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    @Cacheable(value = "roleList",key = "'userId'+#userId")
    public List<UserRole> selectUserRoleListByUserId(Integer userId) {
        return userRoleMapper.selectList(Wrappers.<UserRole>lambdaQuery().eq(UserRole::getUserId, userId));
    }

    /**
    * 根据ID查询角色
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    @Cacheable(value = "role",key = "'roleId'+#roleId")
    public Roles selectRoleById(Integer roleId) {
        return rolesMapper.selectById(roleId);
    }

    /**
    * 根据权限Id查询能访问权限的角色
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    @Cacheable(value = "roleList",key = "'permissionId'+#permissionId")
    public List<RolePermission> selectRolePermissionByPermissionId(Integer permissionId) {
        return rolePermissionMapper.selectList(Wrappers.<RolePermission>lambdaQuery().eq(RolePermission::getPermissionId,permissionId));
    }
}
