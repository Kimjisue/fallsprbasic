package com.thc.fallsprbasic.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id Long id;

    @Setter @Column(unique=true, nullable=false)
    String username;

    @Setter @Column(nullable=false)
    String password;

    @Setter String name;
    @Setter String phone;
}

//id도 setter 해줄 수 있지만 정확하게는 id는 setter 빼는게 맞음