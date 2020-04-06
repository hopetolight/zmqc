package work.chenbo.zmqc.admin.business.user.manager;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.Service;
import work.chenbo.zmqc.admin.business.user.entity.Users;
import work.chenbo.zmqc.admin.business.user.mapper.UsersMapper;
import work.chenbo.zmqc.admin.common.constant.ErrorCode;
import work.chenbo.zmqc.admin.common.exception.DataException;

/**
 * @className UsersManager
 * @authtor ChenBo
 * @date 2020/4/3
 */
@Service
public class UsersManager {

    @Autowired
    private UsersMapper usersMapper;

    /**
    * 根据用户名查找用户
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    public Users selectUserByName(String username) {
        return usersMapper.selectOne(Wrappers.<Users>lambdaQuery().eq(Users::getUsername,username));
    }

    /**
    * 根据用户ID查询用户
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    @Cacheable(value = "user",key = "'userId'+#id")
    public Users selectUserById(Integer id){
        return usersMapper.selectById(id);
    }

    /**
    * 删除用户
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    @Caching(evict = {@CacheEvict(value = "user",key = "'userId'+#users.getId()")
    })
    public Integer deleteUser(Users users){
        return usersMapper.deleteById(users.getId());

    }

    /**
    * 添加用户
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    @Caching(put = {
            @CachePut(value = "user",key = "'userId'+#users.getId()")
    })
    public Users insertUser(Users users) throws DataException {
        int insert = usersMapper.insert(users);
        if(insert>0){
            return users;
        }
        throw new DataException(ErrorCode.INSERT_ERROR.getCode(),ErrorCode.INSERT_ERROR.getMsg());
    }

    /**
    * 更新用户
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    @Caching(put = {
            @CachePut(value = "user",key = "'userId'+#users.getId()")
    })
    public Users updateUser(Users users) throws DataException {
        int update = usersMapper.updateById(users);
        if(update>0){
            return users;
        }
        throw new DataException(ErrorCode.INSERT_ERROR.getCode(),ErrorCode.INSERT_ERROR.getMsg());
    }
}
