package work.chenbo.zmqc.core.system.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Transient;
import work.chenbo.zmqc.common.base.BaseEntity;
import work.chenbo.zmqc.common.constant.CommonConstants;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author ChenBo
 * @className Department
 * @date 2019/12/17
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("t_department")
@ApiModel(value = "部门")
public class Department extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "部门名称")
    private String title;

    @ApiModelProperty(value = "父id")
    private Long parentId;

    @ApiModelProperty(value = "是否为父节点(含子节点) 默认false")
    private Boolean isParent = false;

    @ApiModelProperty(value = "排序值")
    private BigDecimal sortOrder;

    @ApiModelProperty(value = "是否启用 0启用 -1禁用")
    private Integer status = CommonConstants.STATUS_NORMAL;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "父节点名称")
    private String parentTitle;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "主负责人")
    private List<Long> mainHeader;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "副负责人")
    private List<Long> viceHeader;
}
