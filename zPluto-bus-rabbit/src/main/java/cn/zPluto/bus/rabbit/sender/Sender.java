package cn.zPluto.bus.rabbit.sender;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * <p>Description:</p>
 *
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/25.
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void send(){
        String context = "hello"+new Date();
        System.out.println("Sender:"+context);
        this.rabbitTemplate.convertAndSend("hello",context);
    }

}
