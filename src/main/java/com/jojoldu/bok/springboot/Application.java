package com.jojoldu.bok.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        //이것은 내장 WAS : 외부에 was를 두지 않고, 내부에서 실행한다!! 톰캣이 필요없다!
        //왜 내장 WAS? : 언제 어디서나 같은 환경으로 스프링 부트를 배포 할 수 있다.
        SpringApplication.run(Application.class, args);

        //import의 단축키는 alt+enter
        //SpringBootApplication : 스프링부트의 자동설정, 스프링 Bean 읽기 생성을 자동으로 설정

    }
}
