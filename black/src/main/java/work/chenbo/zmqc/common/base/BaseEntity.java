package work.chenbo.zmqc.common.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.format.annotation.DateTimeFormat;
import work.chenbo.zmqc.common.constant.CommonConstants;

import java.io.Serializable;
import java.util.Date;

/**
 * 数据实体模型基类
 * @author ChenBo
 * @className BaseEntity
 * @date 2019/12/17
 */
@Data
public abstract class BaseEntity implements Serializable {

    @ApiModelProperty(value = "唯一标识")
    @TableId
    private Long id;

    @ApiModelProperty(value = "创建者")
    @TableField(fill = FieldFill.INSERT)
    @CreatedBy
    private Long createBy;

    @ApiModelProperty(value = "创建时间")
    @CreatedDate
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新者")
    @LastModifiedBy
    @TableField(fill = FieldFill.UPDATE)
    private Long updateBy;

    @ApiModelProperty(value = "更新时间")
    @LastModifiedDate
    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "删除标志 默认0")
    private Integer delFlag = CommonConstants.STATUS_NORMAL;
}
