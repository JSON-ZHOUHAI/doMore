package cn.zPluto.ribbon.comsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description:</p>
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/16.
 */
@Service
public class ConsumerService {

    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "helloFallback") //指向回调方法
    public String helloConsumer(){
        return  restTemplate.getForEntity("http://ZPLUTO-SERVICE-BASE/hello",String.class).getBody();
    }

    public String helloFallback(){
        return "error";
    }

}
