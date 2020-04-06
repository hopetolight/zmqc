package work.chenbo.zmqc.admin.business.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import work.chenbo.zmqc.admin.common.entity.BaseEntity;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("tab_users")
public class Users extends BaseEntity {

    private String username;

    private String password;

    private Integer status;

    private String nickName;

    @TableField(exist = false)
    private List<Roles> rolesList;

}