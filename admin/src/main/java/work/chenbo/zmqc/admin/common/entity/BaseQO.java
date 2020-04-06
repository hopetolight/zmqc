package work.chenbo.zmqc.admin.common.entity;

import lombok.Data;

/**
 * @className BaseQO
 * @authtor ChenBo
 * @date 2020/3/30
 */
@Data
public abstract class BaseQO {
    private Integer pageNumber;
    private Integer pageSize;
}
