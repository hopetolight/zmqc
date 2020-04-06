package work.chenbo.zmqc.admin.config.mybatis;

import com.baomidou.mybatisplus.core.config.GlobalConfig;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.optimize.JsqlParserCountOptimize;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Mybatis plus 数据库查询组件配置
 * @className MybatisPlusConfiguration
 * @authtor ChenBo
 * @date 2020/3/30
 */
@SpringBootConfiguration
@MapperScan("work.chenbo.zmqc.admin.business.*.mapper")
public class MybatisPlusConfiguration {

    @Autowired
    private MetaObjectHandler metaObjectHandler;

    /**
    * 分页插件
    * @author; ChenBo
    * @datetime: 2020/3/30
    */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        //设置请求的页面大于最大页后操作， true调回到首页，false 继续请求  默认false
        paginationInterceptor.setOverflow(false);
        //设置最大单页限制数量，默认 500 条，-1 不受限制
        paginationInterceptor.setLimit(-1);
        // 开启 count 的 join 优化,只针对部分 left join
        paginationInterceptor.setCountSqlParser(new JsqlParserCountOptimize(true));
        return paginationInterceptor;
    }

    /**
    * 自动设置更新时间和更新人
    * @author; ChenBo
    * @datetime: 2020/3/30
    */
    @Bean
    public GlobalConfig globalConfig(){
        GlobalConfig globalConfig= new GlobalConfig();
        globalConfig.setMetaObjectHandler(metaObjectHandler);
        return globalConfig;
    }
}
