package work.chenbo.zmqc.admin.business.user.service;

import work.chenbo.zmqc.admin.business.user.entity.Permission;

import java.util.List;

/**
 * @interfaceName PermissionService
 * @authtor ChenBo
 * @date 2020/4/3
 */
public interface PermissionService {
    /**
    * 获取全部的被保护权限
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    List<Permission> queryAllPermission();
}
