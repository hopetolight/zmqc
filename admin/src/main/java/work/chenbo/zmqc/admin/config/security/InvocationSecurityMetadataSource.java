package work.chenbo.zmqc.admin.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.PathMatcher;
import work.chenbo.zmqc.admin.business.user.entity.Permission;
import work.chenbo.zmqc.admin.business.user.entity.Roles;
import work.chenbo.zmqc.admin.business.user.service.PermissionService;
import work.chenbo.zmqc.admin.business.user.service.RolesService;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @className InvocationSecurityMetadataSourceFilter
 * @authtor ChenBo
 * @date 2020/3/23
 */
@Service
public class InvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private PermissionService permissionService;
    @Autowired
    private RolesService rolesService;

    @Autowired
    private PathMatcher pathMatcher;

    /**
    * 检查当前访问路径是否为保护资源若不是保护资源则放过
    * @author; ChenBo
    * @datetime: 2020/3/29
    */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        String requestUrl = ((FilterInvocation) object).getRequestUrl();

        // 从缓存中查询保护资源路径
        List<Permission> permissionList = permissionService.queryAllPermission();

        return permissionList.stream().filter(Objects::nonNull)
                // 查找当前请求是否为受保护资源
                .filter(permission -> pathMatcher.match(permission.getPath(), requestUrl))
                // 查询资源可以访问的角色
                .flatMap(permission -> rolesService.queryRolesByPermission(permission.getId()).stream())
                // 返回角色
                .map(roles -> new SecurityConfig(roles.getCode()))
                .distinct().collect(Collectors.toList());
    }


    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
