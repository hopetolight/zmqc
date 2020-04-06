package work.chenbo.zmqc.admin.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

/**
 * @className SecurityProperties
 * @authtor ChenBo
 * @date 2020/4/3
 */
@ConfigurationProperties(prefix = "security")
@Data
public class SecurityProperties {
    /** 忽略地址列表 */
    private List<String> ignorePaths;
}
