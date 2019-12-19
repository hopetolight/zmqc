package work.chenbo.zmqc.pattens;

import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ChenBo
 * @className PattensTest
 * @date 2019/12/16
 */
public class PattensTest {

    @Test
    public void pattensTest(){
        AtomicInteger integer = new AtomicInteger(0);
        String subject = "宝塔镇河妖宝塔镇河妖宝塔镇河妖宝塔镇河妖dlfsakdlskejfidfasddfasdfse";
        Pattern compile = Pattern.compile("(宝塔镇河妖)");
        Matcher matcher = compile.matcher(subject);
        while (matcher.find()){
            integer.set(integer.get()+5);
        }
        System.out.println(integer.get());
    }
}
