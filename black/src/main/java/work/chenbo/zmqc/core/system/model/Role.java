package work.chenbo.zmqc.core.system.model;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Transient;
import work.chenbo.zmqc.common.base.BaseEntity;
import work.chenbo.zmqc.core.system.constant.UserConstant;

import java.util.List;

/**
 * @author ChenBo
 * @className Role
 * @date 2019/12/17
 */
@Data
@TableName("t_role")
@ApiModel(value = "角色")
public class Role extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色名 以ROLE_开头")
    private String name;

    @ApiModelProperty(value = "是否为注册默认角色")
    private Boolean defaultRole;

    @ApiModelProperty(value = "数据权限类型 0全部默认 1自定义 2本部门及以下 3本部门 4仅本人")
    private Integer dataType = UserConstant.DATA_TYPE_ALL;

    @ApiModelProperty(value = "备注")
    private String description;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "拥有权限")
    private List<RolePermission> permissions;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "所在部门")
    private List<RoleDepartment> departments;
}
