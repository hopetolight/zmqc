package work.chenbo.zmqc.core.system.constant;

/**
 * @author ChenBo
 * @interfaceName UserConstant
 * @date 2019/12/17
 */
public interface UserConstant {

    /**
     * 用户默认头像
     */
    String USER_DEFAULT_AVATAR = "https://i.loli.net/2019/04/28/5cc5a71a6e3b6.png";

    /**
     * 用户正常状态
     */
    Integer USER_STATUS_NORMAL = 0;

    /**
     * 用户禁用状态
     */
    Integer USER_STATUS_LOCK = -1;

    /**
     * 普通用户
     */
    Integer USER_TYPE_NORMAL = 0;

    /**
     * 管理员
     */
    Integer USER_TYPE_ADMIN = 1;

    /**
     * 全部数据权限
     */
    Integer DATA_TYPE_ALL = 0;

    /**
     * 自定义数据权限
     */
    Integer DATA_TYPE_CUSTOM = 1;

    /**
     * 部门负责人类型 主负责人
     */
    Integer HEADER_TYPE_MAIN = 0;

    /**
     * 部门负责人类型 副负责人
     */
    Integer HEADER_TYPE_VICE = 1;
}
