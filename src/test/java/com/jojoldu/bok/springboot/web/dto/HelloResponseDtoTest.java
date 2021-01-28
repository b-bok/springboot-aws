package com.jojoldu.bok.springboot.web.dto;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 100;

        //when
        HelloResponseDto dto = new HelloResponseDto(name,amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);  // isEqualTo는 동등비교 메소드, assertThat의 값과 일치하면 성공!
        assertThat(dto.getAmount()).isEqualTo(amount);


        /*
        *  Junit과 비교해서 assertj의 장점은?
        *
        *  1. CoreMatchers와 달리 추가적으로 라이브러리가 필요 없음!
        *   - Junit의 assertThat을 쓰게 되면 is() 같이 CoreMatchers 라이브러리가 필요해짐!
        *
        *  2. 자동완성이 더 확실하게 지원됨!
        *
        *
        * */


    }


}
