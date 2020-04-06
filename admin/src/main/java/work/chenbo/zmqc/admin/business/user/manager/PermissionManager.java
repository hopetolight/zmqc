package work.chenbo.zmqc.admin.business.user.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import work.chenbo.zmqc.admin.business.user.entity.Permission;
import work.chenbo.zmqc.admin.business.user.mapper.PermissionMapper;

import java.util.List;

/**
 * @className PermissionManager
 * @authtor ChenBo
 * @date 2020/4/3
 */
@Service
public class PermissionManager{


    @Autowired
    private PermissionMapper permissionMapper;

    /**
    * 查询全部权限
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    @Cacheable(cacheNames = "permissionAll")
    public List<Permission> selectAllPermission() {
        return permissionMapper.selectList(null);
    }
}
