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
 * spring-cloud-starter-zuul,自身包含了对spring-cloud-starter-hystrix和spring-cloud-starter-ribbon,
 * zuul 天生就拥有线程隔离和断路器的自我保护功能，以及对服务调用的客户端负载均衡功能.
 * 我们zuul通常是用作请求转发以及请求过滤两个功能
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
