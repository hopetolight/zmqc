package work.chenbo.zmqc.admin.config.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
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
 * 用户认证成功处理
 * @className SecuritySuccessHandler
 * @authtor ChenBo
 * @date 2020/3/15
 */
@Service
public class SecuritySuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setStatus(HttpStatus.OK.value());
        response.setContentType(CommonConstants.CONTEXT_TYPE_JSON);
        response.getWriter().write(Objects.requireNonNull(JacksonUtils.toJsonString(ResponseDTO.success(authentication))));
    }
}
