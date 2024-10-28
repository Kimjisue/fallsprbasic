package com.thc.fallsprbasic.domain;

import com.thc.fallsprbasic.dto.DefaultDto;
import com.thc.fallsprbasic.dto.FaqDto;
import com.thc.fallsprbasic.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Faq extends AuditingFields{
    //fk
    @Setter
    Long userId;

    @Setter @Column(nullable = false)
    String title;

    @Setter @Column
    String content;

    protected Faq(){}
    private Faq(Boolean deleted,Long userId, String title, String content){
        this.deleted = deleted;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
    public static Faq of(Long userId, String title, String content){
        return new Faq(false,userId,title,content);
    }

    public DefaultDto.CreateResDto toCreateResDto(){
        return DefaultDto.CreateResDto.builder().id(getId()).build();
    }

}
