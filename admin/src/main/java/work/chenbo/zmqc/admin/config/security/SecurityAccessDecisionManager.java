package work.chenbo.zmqc.admin.config.security;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * @className SecurityAccessDecisionManager
 * @authtor ChenBo
 * @date 2020/3/23
 */
@Slf4j
@Service
public class SecurityAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes) throws AccessDeniedException, InsufficientAuthenticationException {

        // 若权限列表中没有找到访问则放过不做限制
        if(configAttributes == null){
           return;
        }


        if(configAttributes.stream().map(ConfigAttribute::getAttribute)
                .anyMatch(needRoleCode -> authentication.getAuthorities().stream()
                                .map(GrantedAuthority::getAuthority)
                                .anyMatch(roleCode -> StringUtils.equals(needRoleCode.trim(), roleCode))
                )
        ){
            return;
        }

        throw new AccessDeniedException("抱歉，您没有访问权限");
    }


    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }


    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
