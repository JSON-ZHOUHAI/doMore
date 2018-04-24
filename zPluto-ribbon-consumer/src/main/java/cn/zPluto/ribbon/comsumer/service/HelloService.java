package cn.zPluto.ribbon.comsumer.service;

import cn.zPluto.ribbon.comsumer.service.fallback.HelloServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <p>Description:</p>
 *
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/24.
 */
@FeignClient(value = "ZPLUTO-SERVICE-BASE",fallback = HelloServiceFallback.class) //定义接口，通过该注解指定服务名来绑定服务 fallback属性来指定对应的服务降级接口
public interface HelloService {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    String hello();
}
