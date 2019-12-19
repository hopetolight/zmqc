package work.chenbo.zmqc.core.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import work.chenbo.zmqc.common.base.BaseEntity;

/**
 * @author ChenBo
 * @className RoleDepartment
 * @date 2019/12/17
 */
@Data
@TableName("t_role_department")
@ApiModel(value = "角色部门")
public class RoleDepartment extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色id")
    private Long roleId;

    @ApiModelProperty(value = "部门id")
    private Long departmentId;
}
