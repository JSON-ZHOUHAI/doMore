package cn.zPluto.ribbon.comsumer.controller;

import cn.zPluto.ribbon.comsumer.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description:</p>
 * feign 实现的客户单负载均衡
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/24.
 */
@RestController
public class ConsumerFeignController {

    @Autowired
    HelloService helloService;

    @RequestMapping(value= "/feign-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return helloService.hello();
    }
}
