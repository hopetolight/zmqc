package work.chenbo.zmqc.admin.common.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @className BaseEntity
 * @authtor ChenBo
 * @date 2020/3/30
 */
@Data
public abstract class BaseEntity {
    /** 主键 */
    @TableId
    private Integer id;
    /** 创建人ID */
    @TableField(value = "create_by",fill = FieldFill.INSERT)
    private Integer createBy;
    /** 创建人姓名 */
    @TableField(exist = false)
    private String createName;
    /** 创建时间 */
    @TableField(value = "create_time",fill = FieldFill.INSERT)
    private Date createTime;
    /** 更新人ID */
    @TableField(value = "update_by",fill = FieldFill.UPDATE)
    private Integer updateBy;
    /** 更新人名称 */
    @TableField(exist = false)
    private String updateName;
    /** 更新人时间 */
    @TableField(value = "update_time",fill = FieldFill.UPDATE)
    private Date updateTime;
}
