package com.thc.fallsprbasic.domain;

import com.thc.fallsprbasic.dto.NoticeDto;
import com.thc.fallsprbasic.dto.UserDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
public class User extends AuditingFields{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id Long id;

    @Setter @Column(unique=true, nullable=false)
    String username;

    @Setter @Column(nullable=false)
    String password;

    @Setter String name;
    @Setter String phone;

    public UserDto.CreateResDto toCreateResDto(){
        UserDto.CreateResDto res = new UserDto.CreateResDto();
        res.setId(id);
        return res;

    }
}

//id도 setter 해줄 수 있지만 정확하게는 id는 setter 빼는게 맞음