package work.chenbo.zmqc.admin.business.user.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import work.chenbo.zmqc.admin.business.user.entity.Users;
import work.chenbo.zmqc.admin.business.user.manager.UsersManager;
import work.chenbo.zmqc.admin.business.user.service.UserService;
import work.chenbo.zmqc.admin.common.exception.DataException;

/**
 * @className UserServiceImpl
 * @authtor ChenBo
 * @date 2020/4/3
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersManager usersManager;

    /**
     * 根据用户名查找用户
     *
     * @param username
     * @author; ChenBo
     * @datetime: 2020/4/3
     */
    @Override
    public Users queryUserByName(String username) {
        return usersManager.selectUserByName(username);
    }

    /**
     * 添加用户
     *
     * @param users
     * @author; ChenBo
     * @datetime: 2020/4/4
     */
    @Override
    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.SERIALIZABLE,rollbackFor = Exception.class)
    public int addUser(Users users) throws DataException {
        Users users1 = usersManager.insertUser(users);
        if(users1!=null){
            return 1;
        }else {
            return 0;
        }

    }
}
