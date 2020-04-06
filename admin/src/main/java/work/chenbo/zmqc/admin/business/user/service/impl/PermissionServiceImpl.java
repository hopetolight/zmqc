package work.chenbo.zmqc.admin.business.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.chenbo.zmqc.admin.business.user.entity.Permission;
import work.chenbo.zmqc.admin.business.user.manager.PermissionManager;
import work.chenbo.zmqc.admin.business.user.service.PermissionService;

import java.util.List;

/**
 * @className PermissionServiceImpl
 * @authtor ChenBo
 * @date 2020/4/3
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    @Autowired
    private PermissionManager permissionManager;

    /**
     * 获取全部的被保护权限
     *
     * @author; ChenBo
     * @datetime: 2020/4/3
     */
    @Override
    public List<Permission> queryAllPermission() {
        return permissionManager.selectAllPermission();
    }
}
