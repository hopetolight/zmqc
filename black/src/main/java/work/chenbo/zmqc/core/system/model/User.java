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
 * @className User
 * @date 2019/12/17
 */
@ApiModel(value = "用户")
@TableName("t_user")
@Data
public class User extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "手机")
    private String mobile;

    @ApiModelProperty(value = "邮件")
    private String email;

    @ApiModelProperty(value = "省市县地址")
    private String address;

    @ApiModelProperty(value = "街道地址")
    private String street;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "密码强度")
    private String passStrength;

    @ApiModelProperty(value = "用户头像")
    private String avatar = UserConstant.USER_DEFAULT_AVATAR;

    @ApiModelProperty(value = "用户类型 0普通用户 1管理员")
    private Integer type = UserConstant.USER_TYPE_NORMAL;

    @ApiModelProperty(value = "状态 默认0正常 -1拉黑")
    private Integer status = UserConstant.USER_STATUS_NORMAL;

    @ApiModelProperty(value = "描述/详情/备注")
    private String description;

    @ApiModelProperty(value = "所属部门id")
    private String departmentId;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "所属部门名称")
    private transient String departmentTitle;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "用户拥有角色")
    private transient List<Role> roles;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "用户拥有的权限")
    private transient List<Permission> permissions;

    @Transient
    @TableField(exist=false)
    @ApiModelProperty(value = "导入数据时使用")
    private transient Integer defaultRole;
}
