package cn.zPluto.oauth2.server.controller;

import cn.zPluto.oauth2.server.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouh
 * @description
 * @date 2018/8/30
 *
 */

@RestController
@RequestMapping("/")
public class TextController {
    @PostMapping(value = "/log")
    public String  saveCuringEvidence(@RequestBody User user){
        System.out.println("---------------------user:"+user.getUsername());
        return user.getUsername();
    }
}
