package me.maiz.ds.emall.web;

import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import me.maiz.ds.emall.UserLoginService;
import me.maiz.ds.emall.common.Result;
import me.maiz.ds.emall.info.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;


@Controller
@Slf4j
public class LoginController {


    @GetMapping("login")
    public String login(){
        return "login";
    }

    @RequestMapping("/user/me")
    @ResponseBody
    public Principal getUserInfo(Principal principal){
        log.info("用户信息：{}",principal);
        return principal;
    }

}
