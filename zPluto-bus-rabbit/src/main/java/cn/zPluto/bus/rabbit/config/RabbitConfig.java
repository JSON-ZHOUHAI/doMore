package cn.zPluto.bus.rabbit.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Description:</p>
 *
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/26.
 */
@Configuration
public class RabbitConfig {
    public Queue helloQueue(){
        return new Queue("hello");
    }
}
