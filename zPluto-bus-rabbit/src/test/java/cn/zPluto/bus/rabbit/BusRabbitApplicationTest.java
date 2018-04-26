package cn.zPluto.bus.rabbit;

import cn.zPluto.bus.rabbit.sender.Sender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>Description:</p>
 *
 * @author zhouh
 * @version 1.0
 * @Date 2018/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes =BusRabbitApplication.class)
public class BusRabbitApplicationTest {

    @Autowired
    private Sender sender;

    @Test
    public void hello(){
        sender.send();
    }

}

