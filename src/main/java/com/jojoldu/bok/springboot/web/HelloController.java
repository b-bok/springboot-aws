package com.jojoldu.bok.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//신세계다! 메서드마다 @ResponseBody를 쓰지 않아도된다! @RestController가 한번에 도와준다
@RestController
public class HelloController {

    //@RequestMapping이 아니라 요걸로!간결하다...
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
}
