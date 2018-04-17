package cn.zPluto.api.zuul;

import cn.zPluto.api.zuul.filter.AccessFilter;
import com.sun.glass.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * <p>Description:</p>
 *
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/17.
 */
@EnableZuulProxy
@SpringCloudApplication
public class ApiZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiZuulApplication.class,args);
    }

    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
}
