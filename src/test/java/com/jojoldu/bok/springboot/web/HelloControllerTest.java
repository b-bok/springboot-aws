package com.jojoldu.bok.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
* @RunWith : JUnit 내장 실행자외 다른 실행자 여기서는 SpringRunner를 실행자로 하겠다!
*   즉, 스프링부트 테스트와 JUnit 사이에 연결자 역할
*
* @WebMvcTest : 여러 스프링 테스트 어노테이션 중 => Web에 집중 할 수 있는 어노테이션
*   @Controller, @ControllerAdvice등은 사용가능
    * @Service, @Component, @Repository 사용 불가
*
*
* @MockMvc :
*   웹API 테스트시 사용
*   스프링 MVC 테스트의 시작점
*   이 클래스를 통해서 HTTP GET, POST등의 API를 테스트 할 수있습니다!
*
* @mvc.perform(get("/hello"))
*   MockMvc를 통해 /hello 주소로 HTTP GET요청
*   체이닝 지원됨! => 여러 검증 기능 이어서 쓸수 있다!
*
* .andExpect(status().isOk())
*   mvc.perform의 결과를 검증!
*   HTTP Header Status 검증
*   200,404,500등의 상태 검증
*   여기선 ok => 즉 200인지 아닌지 확인!
*
* .andExpect(content().string(hello));
*   mvc.perform의 결과를 검증!
*   응답 본문의 내용을 검증!
*
*
* */




@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string(hello));
    }

}
