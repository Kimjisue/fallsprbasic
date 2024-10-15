package com.thc.fallsprbasic.domain;

import com.thc.fallsprbasic.dto.FaqDto;
import com.thc.fallsprbasic.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Faq {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id Long id;

    //fk
    @Setter
    Long userId;

    @Setter @Column(nullable = false)
    String title;

    @Setter @Column
    String content;


    //생성자는 그냥 안쓰고 싶다. of라는 메서드를 통해서만 엔티티 인스턴스를 만들고 싶다.
    protected Faq(){}
    private Faq(Long userId, String title, String content){
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
    public static Faq of(Long userId, String title, String content){
        return new Faq(userId,title,content);
    }

    public FaqDto.CreateResDto toCreateResDto(){
//        FaqDto.CreateResDto dto = new FaqDto.CreateResDto();
//        dto.setId(id);
        return FaqDto.CreateResDto.builder().id(id).build();
        //return dto;

    }

}
