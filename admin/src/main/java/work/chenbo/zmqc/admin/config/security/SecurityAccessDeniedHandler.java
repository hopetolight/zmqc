package work.chenbo.zmqc.admin.config.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
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
 * 没有权限访问处理类
 * @className SecurityAccessDeniedHandler
 * @authtor ChenBo
 * @date 2020/3/23
 */
@Service
public class SecurityAccessDeniedHandler implements AccessDeniedHandler {

    /**
    * 没有权限处理
    * @author; ChenBo
    * @datetime: 2020/3/23
    */
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        response.setContentType(CommonConstants.CONTEXT_TYPE_JSON);
        response.setStatus(HttpStatus.FORBIDDEN.value());
        response.getWriter().write(Objects.requireNonNull(JacksonUtils.toJsonString(ResponseDTO.fail(403, "没有权限访问数据"))));
    }
}
