package work.chenbo.zmqc.admin.common.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @className ResponseDTO
 * @authtor ChenBo
 * @date 2020/1/4
 */
@Data
public class ResponseDTO implements Serializable {
    private Integer code;
    private String msg;
    private Object data;
    public ResponseDTO(Integer code, String msg, Object data) {
        this.msg=msg;
        this.code=code;
        this.data=data;
    }

    /**
    * 成功响应
    * @author; ChenBo
    * @datetime: 2020/1/4
    */
    public static ResponseDTO success(Object data){
        return new ResponseDTO(200,"success",data);
    }

    /**
    * 成功响应
    * @author; ChenBo
    * @datetime: 2020/1/4
    */
    public static ResponseDTO success(String msg, Object data){
        return new ResponseDTO(200,msg,data);
    }

    /**
     * 成功响应
     * @author; ChenBo
     * @datetime: 2020/1/4
     */
    public static ResponseDTO success(Integer code, String msg, Object data){
        return new ResponseDTO(code,msg,data);
    }

    /**
    * 失败响应
    * @author; ChenBo
    * @datetime: 2020/1/4
    */
    public static ResponseDTO fail(String msg){
        return  new ResponseDTO(-1,msg,null);
    }
    
    /**
    * 失败响应
    * @author; ChenBo
    * @datetime: 2020/1/4
    */
    public static ResponseDTO fail(Integer code, String msg){
        return  new ResponseDTO(code,msg,null);
    }

    @Override
    public String toString() {
        return "ResponseDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
