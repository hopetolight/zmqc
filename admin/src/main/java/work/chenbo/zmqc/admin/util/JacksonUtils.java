package work.chenbo.zmqc.admin.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Jackson 工具类
 * @className JacksonUtils
 * @authtor ChenBo
 * @date 2020/4/3
 */
public class JacksonUtils {

    /**
    * 转换为JSON字符串
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    public static String toJsonString(Object obj){
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
    * 转换为JSON字符串,忽略空值
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    public static String toJsonStringIgnoreNull(Object obj){
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
            return objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
    * 转换为 Java对象
    * @author; ChenBo
    * @datetime: 2020/4/3
    */
    public static <T> T toJavaObject(String json,Class<T> clazz) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY,true);
            return objectMapper.readValue(json,clazz);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
}
