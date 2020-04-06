package work.chenbo.zmqc.admin.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className LoginController
 * @authtor ChenBo
 * @date 2020/4/4
 */
@Controller
public class LoginController {

    /**
    * 登录页面请求
    * @author; ChenBo
    * @datetime: 2020/4/4
    */
    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    /**
    * 主页请求
    * @author; ChenBo
    * @datetime: 2020/4/4
    */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
