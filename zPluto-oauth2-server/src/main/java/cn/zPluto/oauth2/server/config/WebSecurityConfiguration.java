package cn.zPluto.oauth2.server.config;  /**
 * @Title: WebSecurityConfiguration
 * @ProjectName uus
 * @Description: TODO
 * @author DELL
 * @date 2018/8/3014:33
 */

import cn.zPluto.oauth2.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;

/**
 * @author zhouh
 * @description
 * @date 2018/8/30
 *
 */
@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

//    @Autowired
//    private final UserService userService;
//
//    @Autowired
//    public WebSecurityConfiguration(UserService userService) {
//        this.userService = userService;
//    }
//
//    @Override
//    public void init(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userService);
//
//    }
}
