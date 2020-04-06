package work.chenbo.zmqc.admin.business.user.service;

import work.chenbo.zmqc.admin.business.user.entity.Users;
import work.chenbo.zmqc.admin.common.exception.DataException;

/**
 * @className UserService
 * @authtor ChenBo
 * @date 2020/4/3
 */
public interface UserService {


    /**
    * 根据用户名查找用户
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    Users queryUserByName(String username);

    /**
    * 添加用户
    * @author; ChenBo
    * @datetime: 2020/4/4
    */
    int addUser(Users users) throws DataException;
}
