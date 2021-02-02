package com.jojoldu.bok.springboot.domain.posts;

// 주요 어노테이션을 클래스에 가깝게 두자 :
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;    //JPA 어노테이션
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor //기본 생성자 자동 추가
@Entity
public class Posts {// 실제로  DB테이블과 매칭될 클래스 == Entity 클래스 // 클래스의 카멜케이스 이름 => 언더스코어 네이밍 테이블
    // SalesManager.java => slaes_manager table

    @Id // PK필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK 생성 규칙
    private Long id;

    @Column(length = 500, nullable = false) // 테이블 컬럼을 의미, 기본값 + 추가로 변경이 필요한 옵션이 있으면 사용
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
