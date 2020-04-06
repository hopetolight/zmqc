package work.chenbo.zmqc.admin.common.constant;

/**
 * @enumName ErrorCode
 * @authtor ChenBo
 * @date 2020/4/3
 */
public enum ErrorCode {


    INSERT_ERROR(1001,"新增异常"),
    UPDATE_ERROR(1002,"更新异常"),
    DELETE_ERROR(1003,"删除异常");

    private int code;
    private String msg;

    ErrorCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return this.code + " " + name();
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
