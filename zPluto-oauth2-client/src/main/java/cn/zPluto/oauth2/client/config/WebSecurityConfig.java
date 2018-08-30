package cn.zPluto.oauth2.client.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author zhouh
 * @description
 * @date 2018/8/30
 *
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 全部通过
//        http.csrf().disable().authorizeRequests()
//                .anyRequest()
//                .permitAll();

        //允许所有用户访问"/"和"/home" 条件判断
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/page-login.html").permitAll()
                //其他地址的访问均需验证权限
                .antMatchers("/*.html").authenticated()
                .and()
                .formLogin()
                //指定登录页是"/login"
                .loginPage("/login")
                .defaultSuccessUrl("/otherPage")//登录成功后默认跳转到"/index.html"
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login")//退出登录后的默认url是"/login"
                .invalidateHttpSession(true)
                .permitAll();
    }
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        //将验证过程交给自定义验证工具
//        auth.authenticationProvider(provider);
//    }
}
