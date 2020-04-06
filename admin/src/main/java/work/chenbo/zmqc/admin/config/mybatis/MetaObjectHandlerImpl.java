package work.chenbo.zmqc.admin.config.mybatis;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import work.chenbo.zmqc.admin.common.entity.SecurityUserDetails;

import java.util.Date;

/**
 * @className MetaObjectHandlerImpl
 * @authtor ChenBo
 * @date 2020/3/30
 */
@Service
public class MetaObjectHandlerImpl implements MetaObjectHandler {

    /**
    * 插入元对象字段填充（用于插入时对公共字段的填充）
    * @author; ChenBo
    * @datetime: 2020/3/30
    */
    @Override
    public void insertFill(MetaObject metaObject) {
        SecurityUserDetails securityUserDetails = (SecurityUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(securityUserDetails!=null && securityUserDetails.getId()!=null){
            this.setFieldValByName("createBy",securityUserDetails.getId(),metaObject);
        }
        this.setFieldValByName("createTime",new Date(),metaObject);
    }

    /**
    * 更新元对象字段填充（用于更新时对公共字段的填充）
    * @author; ChenBo
    * @datetime: 2020/3/30
    */
    @Override
    public void updateFill(MetaObject metaObject) {
        SecurityUserDetails securityUserDetails = (SecurityUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(securityUserDetails!=null && securityUserDetails.getId()!=null){
            this.setFieldValByName("updateBy",securityUserDetails.getId(),metaObject);
        }
        this.setFieldValByName("updateTime", new Date(),metaObject);
    }
}
