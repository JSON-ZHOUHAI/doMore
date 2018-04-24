package cn.zPluto.ribbon.comsumer.service.fallback;

import cn.zPluto.ribbon.comsumer.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * <p>Description:</p>
 * fegin服务降级的配置  服务降级逻辑的实现只需要为Feign客户端的定义接口编写一个具体的接口实现类，
 * 比如为HelloService接口实现一个服务降级类HelloServiceFallback，其中没个重新方法的实现逻辑都可以用来定义相应的服务降级逻辑。
 *
 * 当正常的服务请求不能正常返回的时候，调用进入服务降级的方法。
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/24.
 */
@Component
public class HelloServiceFallback  implements HelloService {

    @Override
    public String hello() {
        return "error";
    }
}
