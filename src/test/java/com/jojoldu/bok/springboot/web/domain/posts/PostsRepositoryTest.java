package com.jojoldu.bok.springboot.web.domain.posts;

import com.jojoldu.bok.springboot.domain.posts.Posts;
import com.jojoldu.bok.springboot.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanUp() { //여러 테스트가 동시에 수행될 경우 DB를 비워주기 위한 작업
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "test title";
        String content = "test content";
        
        // 테이블 posts에 insert/update 쿼리 실행
        postsRepository.save(Posts.builder()
                                .title(title)
                                .content(content)
                                .author("hooyuki123@gmail.com")
                                .build()
        );
        
        //when
        List<Posts> postsList = postsRepository.findAll(); //findAll == 모든 데이터 조회하는 메소드
        
        //then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
        
    }


}
