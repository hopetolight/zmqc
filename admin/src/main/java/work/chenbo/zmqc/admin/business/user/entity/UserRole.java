package work.chenbo.zmqc.admin.business.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import work.chenbo.zmqc.admin.common.entity.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("tab_user_role")
public class UserRole extends BaseEntity {

    private Integer roleId;

    private Integer userId;



}