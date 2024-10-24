package com.thc.fallsprbasic.domain;

import com.thc.fallsprbasic.dto.NoticeDto;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class Notice  extends AuditingFields{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id Long id;

    @Setter @Column(nullable = false)
    String title;

    @Setter @Column
    String content;

    public NoticeDto.CreateResDto toCreateResDto(){
        NoticeDto.CreateResDto dto = new NoticeDto.CreateResDto();
        dto.setId(id);
        return dto;

    }

}
