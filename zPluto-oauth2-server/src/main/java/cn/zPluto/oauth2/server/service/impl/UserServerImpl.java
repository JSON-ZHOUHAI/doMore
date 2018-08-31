package cn.zPluto.oauth2.server.service.impl;

import cn.zPluto.oauth2.server.dto.CustomUserDetails;
import cn.zPluto.oauth2.server.model.User;
import cn.zPluto.oauth2.server.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author zhouh
 * @description
 * @date 2018/8/30
 */
public class UserServerImpl  implements UserService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("===================获取到token已进入自定义验证："+username);
        // 可以进行数据库请求，这里进行模拟
        User user = new User();
        user.setUsername("110");
        user.setPassword("110119");
        if (user == null) {
            System.out.println("==================="+username);
            throw new UsernameNotFoundException("Could not find the user '" + username + "'");
        }
        return new CustomUserDetails(user, true, true, true, true, null);
    }
}
