package work.chenbo.zmqc.core.system.model;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import work.chenbo.zmqc.core.system.constant.UserConstant;

/**
 * @author ChenBo
 * @className DepartmentHeader
 * @date 2019/12/17
 */
@Data
@TableName("t_department_header")
@ApiModel(value = "部门负责人")
public class DepartmentHeader {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "关联部门id")
    private Long departmentId;

    @ApiModelProperty(value = "关联部门负责人")
    private Long userId;

    @ApiModelProperty(value = "负责人类型 默认0主要 1副职")
    private Integer type = UserConstant.HEADER_TYPE_MAIN;
}
