package cn.zPluto.bus.rabbit.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>Description:</p>
 *
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/25.
 */
@Component
@RabbitListener(queues="hello")
public class Receiver {

    @RabbitHandler
    public void process(String hello){
        System.out.println("Receiver :"+hello);
    }
}

