package me.maiz.ds.emall.service;

import com.alibaba.dubbo.config.annotation.Reference;
import me.maiz.ds.emall.UserLoginService;
import me.maiz.ds.emall.common.Result;
import me.maiz.ds.emall.info.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * spring-security用于集成用户数据的接口
 */
@Component
public class SecurityDubboUserDetailService implements UserDetailsService {


    @Reference
    private UserLoginService userLoginService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


       @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    //访问dubbo服务，获取用户信息
           Result<UserInfo> result = userLoginService.findUserByName(username);
           if(!result.isSuccess()){
               throw new RuntimeException("登录服务访问出错：["+result.getMessage()+"]");
           }
           UserInfo userInfo = (UserInfo)result.getData();
           UserDetails userDetails = new User(userInfo.getUsername(),passwordEncoder.encode(userInfo.getPassword()),getAuthorities());

        return userDetails;
    }

    /**  * 获取用户的角色权限,为了降低实验的难度，这里去掉了根据用户名获取角色的步骤     * @param    * @return   */
    private Collection<GrantedAuthority> getAuthorities(){
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority("ROLE_USER"));
        authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
        return authList;
    }
}
