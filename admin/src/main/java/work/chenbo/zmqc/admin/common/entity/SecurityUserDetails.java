package work.chenbo.zmqc.admin.common.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import work.chenbo.zmqc.admin.business.user.entity.Roles;
import work.chenbo.zmqc.admin.business.user.entity.Users;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @className SecurityUserDetails
 * @authtor ChenBo
 * @date 2020/3/30
 */
public class SecurityUserDetails extends Users implements UserDetails {

    public SecurityUserDetails(Users users) {
        if(users!=null) {
            this.setId(users.getId());
            this.setUsername(users.getUsername());
            this.setPassword(users.getPassword());
            this.setRolesList(users.getRolesList());
        }
    }


    /**
     * 添加用户拥有的角色
     * @author; ChenBo
     * @datetime: 2020/3/23
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<Roles> rolesList = this.getRolesList();
        List<GrantedAuthority> authorityList = rolesList.stream()
                .map(roles -> new SimpleGrantedAuthority(roles.getCode()))
                .collect(Collectors.toList());

        // 测试通用权限
        authorityList.add(new SimpleGrantedAuthority("authorities"));

        return authorityList;
    }

    /**
     * Returns the username used to authenticate the user. Cannot return <code>null</code>.
     *
     * @return the username (never <code>null</code>)
     */
    @Override
    public String getUsername() {
        return null;
    }

    /**
     * 账户是否过期
     * @author; ChenBo
     * @datetime: 2020/3/23
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * 账户师傅没有锁定
     * @author; ChenBo
     * @datetime: 2020/3/23
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * 密码是否没过期
     * @author; ChenBo
     * @datetime: 2020/3/23
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * 是否启用
     * @author; ChenBo
     * @datetime: 2020/3/23
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
