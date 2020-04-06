package work.chenbo.zmqc.admin.business.user.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import work.chenbo.zmqc.admin.common.entity.BaseEntity;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("tab_permission")
public class Permission extends BaseEntity {

    private String name;

    private Integer type;

    private Integer parentId;

    private String path;

}