package com.jojoldu.bok.springboot.web;

import com.jojoldu.bok.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//신세계다! 메서드마다 @ResponseBody를 쓰지 않아도된다! @RestController가 한번에 도와준다
@RestController
public class HelloController {

    //@RequestMapping이 아니라 요걸로!간결하다...
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }


    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {

        //@RequestParam
        //외부에서 API로 넘긴 파라미터를 가져오는 어노테이션 입니다.


        return new HelloResponseDto(name,amount);
    }

}
