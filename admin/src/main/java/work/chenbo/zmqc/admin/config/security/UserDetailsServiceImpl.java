package work.chenbo.zmqc.admin.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import work.chenbo.zmqc.admin.business.user.entity.Roles;
import work.chenbo.zmqc.admin.business.user.entity.Users;
import work.chenbo.zmqc.admin.business.user.service.RolesService;
import work.chenbo.zmqc.admin.business.user.service.UserService;
import work.chenbo.zmqc.admin.common.entity.SecurityUserDetails;

import java.util.List;

/**
 * 用户信息获取
 * @className UserDetailsServiceImpl
 * @authtor ChenBo
 * @date 2020/3/20
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UserService userService;
    @Autowired
    private RolesService rolesService;

    /**
    * 从数据库获取用户信息和权限
    * @author; ChenBo
    * @datetime: 2020/3/20
    */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userService.queryUserByName(username);
        if(users==null) {
            throw new UsernameNotFoundException("用户名错误");
        }
        List<Roles> rolesList = rolesService.queryRolesByUser(users.getId());
        users.setRolesList(rolesList);
        return  new SecurityUserDetails(users);


    }
}
