package cn.zPluto.eureka.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * <p>Description:</p>
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/12.
 */
@EnableEurekaServer  //启动一个服务注册中心提供给其他应用进行对话
@SpringBootApplication
public class EurekaCenterApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaCenterApplication.class, args);
    }
}

