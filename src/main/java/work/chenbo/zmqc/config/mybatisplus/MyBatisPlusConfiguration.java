package work.chenbo.zmqc.config.mybatisplus;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * mybatis 配置
 * @author ChenBo
 * @className MyBatisPlusConfiguration
 * @date 2019/12/16
 */
@SpringBootConfiguration
@MapperScan({"work.zmqc.core.*.mapper"})
public class MyBatisPlusConfiguration {

    /**
     * 分页插件
     * @author ChenBo
     * @date 2019/12/16
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
