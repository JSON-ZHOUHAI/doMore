package cn.zPluto.ribbon.comsumer;

import feign.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description:</p>
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/12.
 */


@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients  //开启spring feign
@EnableAutoConfiguration
@EnableHystrix
@EnableHystrixDashboard
public class RibbonConsumerApplication {

    /**
     * ribbon负载均衡开启
     * @return
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }


    @Bean
    Logger.Level  feignLoggerLevel(){
       return Logger.Level.FULL;
    }


    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class,args);
    }
}
