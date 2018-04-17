package cn.zPluto.ribbon.comsumer.controller;

import cn.zPluto.ribbon.comsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * <p>Description:</p>
 *
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/12.
 */
@RestController
public class ConsumerController {

    @Autowired
    ConsumerService consumerService;

    @RequestMapping(value= "/ribbon-consumer",method = RequestMethod.GET)
    public String helloConsumer(){
        return  consumerService.helloConsumer();
    }
}
