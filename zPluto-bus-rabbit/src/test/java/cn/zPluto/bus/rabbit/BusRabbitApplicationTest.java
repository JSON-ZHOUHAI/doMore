package cn.zPluto.bus.rabbit;

import cn.zPluto.bus.rabbit.sender.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>Description:</p>
 *
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/26.
 */

@RunWith(SpringRunner.class)
@SpringBootTest

public class BusRabbitApplicationTest {

    @Autowired
    private Sender sender;

    @Test
    public void hello(){
        sender.send();
    }

}

