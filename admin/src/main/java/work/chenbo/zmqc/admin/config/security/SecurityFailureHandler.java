package work.chenbo.zmqc.admin.config.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Service;
import work.chenbo.zmqc.admin.common.constant.CommonConstants;
import work.chenbo.zmqc.admin.common.entity.ResponseDTO;
import work.chenbo.zmqc.admin.util.JacksonUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * 登录认证失败处理
 * @className SecurityFailureHandler
 * @authtor ChenBo
 * @date 2020/3/15
 */
@Service
public class SecurityFailureHandler implements AuthenticationFailureHandler {

    /**
    * 监听登录失败
    * @author; ChenBo
    * @datetime: 2020/3/15
    */
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        response.setContentType(CommonConstants.CONTEXT_TYPE_JSON);
        response.setStatus(HttpStatus.OK.value());
        if(exception instanceof UsernameNotFoundException){
            response.getWriter().write(Objects.requireNonNull(JacksonUtils.toJsonStringIgnoreNull(ResponseDTO.fail(1001, "用户名错误"))));
        }else {
            response.getWriter().write(Objects.requireNonNull(JacksonUtils.toJsonStringIgnoreNull(ResponseDTO.fail(1001, "登录失败"))));
        }

    }
}
