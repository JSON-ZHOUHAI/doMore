package cn.zPluto.service.base.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>Description:</p>
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/12.
 */
@RefreshScope //注解@RefreshScope指示Config客户端在服务器配置改变时，也刷新注入的属性值
@RestController
public class HelloController {

    @Autowired
    private DiscoveryClient client;

    @Value("${form}")
    private String from;

    @RequestMapping(value="/hello",method = RequestMethod.GET)
    public String index(){
        return "Hello World"+this.from;
    }

}
