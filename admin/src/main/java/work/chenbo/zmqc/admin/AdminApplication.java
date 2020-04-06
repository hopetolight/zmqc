package work.chenbo.zmqc.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @className AdminApplication
 * @authtor ChenBo
 * @date 2020/3/30
 */
@SpringBootApplication
// 开启缓存
@EnableCaching
// 开启事务
@EnableTransactionManagement
public class AdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(AdminApplication.class,args);
    }
}
