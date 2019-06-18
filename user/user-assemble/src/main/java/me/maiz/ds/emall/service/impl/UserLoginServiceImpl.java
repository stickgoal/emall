package me.maiz.ds.emall.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import lombok.extern.slf4j.Slf4j;
import me.maiz.ds.emall.UserLoginService;
import me.maiz.ds.emall.common.Result;
import me.maiz.ds.emall.dao.UserRepo;
import me.maiz.ds.emall.dao.model.User;
import me.maiz.ds.emall.info.UserInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Service(interfaceClass = UserLoginService.class)
@Slf4j
public class UserLoginServiceImpl implements UserLoginService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public Result checkUsernameExist(String username) {
        return null;
    }

    @Override
    public Result<UserInfo> login(String username, String password) {
        log.info("username:{},password:{}",username,password);
        try {
            User user = userRepo.findByUsernameAndPassword(username, password);
            if (user != null) {
                UserInfo u = new UserInfo();
                BeanUtils.copyProperties(user, u);
                return Result.success(u);
            }else{
                return Result.fail("USERNAME_OR_PASSWORD_NOT_CORRECT","请重新输入用户名或密码");
            }
        }catch (Exception e){
            log.warn("登录异常",e);
            return Result.generalFail();
        }

    }
}
