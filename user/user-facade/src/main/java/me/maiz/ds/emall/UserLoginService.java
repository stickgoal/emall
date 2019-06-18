package me.maiz.ds.emall;

import me.maiz.ds.emall.common.Result;
import me.maiz.ds.emall.info.UserInfo;

/**
 * 用户登录服务
 */
public interface UserLoginService {
    /**
     * 校验用户名是否存在
     * @param username
     * @return
     */
    Result checkUsernameExist(String username);

    /**
     * 登录操作
     * @param username
     * @param password
     * @return
     */
    Result<UserInfo> login(String username, String password);

}
