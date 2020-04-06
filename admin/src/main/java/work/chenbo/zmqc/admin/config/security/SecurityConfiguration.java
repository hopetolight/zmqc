package work.chenbo.zmqc.admin.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import work.chenbo.zmqc.admin.config.properties.SecurityProperties;

/**
 * 权限配置
 * @className SecurityConfiguration
 * @authtor ChenBo
 * @date 2020/4/3
 */
@SpringBootConfiguration
@EnableWebSecurity
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    /** 配置文件对象 */
    @Autowired
    private SecurityProperties securityProperties;

    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;

    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private SecurityAccessDeniedHandler securityAccessDeniedHandler;

    @Autowired
    private SecurityInterceptorFilter securityInterceptorFilter;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry registry = http.authorizeRequests();
        registry.antMatchers("/static/**").permitAll();
        if(securityProperties.getIgnorePaths()!=null && securityProperties.getIgnorePaths().size()>0){
            for (String url : securityProperties.getIgnorePaths()){
                registry.antMatchers(url).permitAll();
            }
        }
        registry.and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/login")
                .permitAll()
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler)
                // 允许网页iframe
                .and().headers().frameOptions().disable()
                .and()
                .logout().permitAll()
                .and()
                .authorizeRequests()
                // 任何请求
                .anyRequest()
                // 需要身份认证
                .authenticated()
                // 关闭跨站请求防护
                .and().csrf().disable()
                // 允许跨域
                .cors().disable()
                // 自定义权限拒绝处理类
                .exceptionHandling().accessDeniedHandler(securityAccessDeniedHandler)
                .and()
                // 添加自定义权限过滤器
                .addFilterBefore(securityInterceptorFilter, FilterSecurityInterceptor.class);
    }

    /**
     * SpringBoot2.0抛弃了原来的NoOpPasswordEncoder，
     * 要求用户保存的密码必须要使用加密算法后存储，
     * 在登录验证的时候Security会将获得的密码在进行编码后再和数据库中加密后的密码进行对比
     * @author; ChenBo
     * @datetime: 2020/3/15
     */
    @Bean
    @Deprecated
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
