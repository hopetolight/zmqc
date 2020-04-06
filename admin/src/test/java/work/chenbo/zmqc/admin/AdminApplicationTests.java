package work.chenbo.zmqc.admin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import work.chenbo.zmqc.admin.business.user.entity.Users;
import work.chenbo.zmqc.admin.business.user.manager.UsersManager;
import work.chenbo.zmqc.admin.business.user.service.UserService;
import work.chenbo.zmqc.admin.common.exception.DataException;

import java.util.Date;

/**
 * @className AdminApplicationTests
 * @authtor ChenBo
 * @date 2020/3/30
 */
@SpringBootTest
// 开启缓存
@EnableCaching
public class AdminApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UsersManager usersManager;
    @Test
    public void test(){
        Users users = usersManager.selectUserById(1);
        System.out.println(users);
    }
}
