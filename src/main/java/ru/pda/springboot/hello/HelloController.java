package ru.pda.springboot.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SuppressWarnings("unused")
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String sayHello() {     // todo: no @ResponseBody?
        return "Hello world";
    }
}