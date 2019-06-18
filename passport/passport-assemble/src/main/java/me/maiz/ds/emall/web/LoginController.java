package me.maiz.ds.emall.web;

import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import me.maiz.ds.emall.UserLoginService;
import me.maiz.ds.emall.common.Result;
import me.maiz.ds.emall.info.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoginController {

    @Reference
    private UserLoginService userLoginService;


    @RequestMapping("login")
    public Result login(String username,String password){
        log.info("username:{},password:{}",username,password);
        Result<UserInfo> loginResult = userLoginService.login(username, password);
        return loginResult;
    }

}
