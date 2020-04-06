package work.chenbo.zmqc.admin.common.exception;

/**
 * @className DataException
 * @authtor ChenBo
 * @date 2020/4/3
 */
public class DataException extends Exception {

    private Integer errorCode;

    public DataException(Integer errorCode){
        super();
        this.errorCode = errorCode;
    }

    public DataException(Integer errorCode, String msg, Throwable t) {
        super(msg, t);
        this.errorCode = errorCode;
    }

    public DataException(Integer errorCode, String msg) {
        super(msg);
        this.errorCode = errorCode;
    }
}
