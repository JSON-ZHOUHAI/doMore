package cn.zPluto.oauth2.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhouh
 * @description
 * @date 2018/8/30
 *
 */
@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/blog/{id}")
    public String getBlogById(@PathVariable long id) {
        return "this is blog "+id;
    }

}
