package work.chenbo.zmqc.admin.business.user.service;

import work.chenbo.zmqc.admin.business.user.entity.Roles;

import java.util.List;

/**
 * @interfaceName RolesService
 * @authtor ChenBo
 * @date 2020/4/3
 */
public interface RolesService {
    /**
    * 根据权限ID查询可以访问角色列表
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    List<Roles> queryRolesByPermission(Integer permissionId);

    /**
    * 根据用户ID查询用户所具有的角色
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    List<Roles> queryRolesByUser(Integer userId);
}
