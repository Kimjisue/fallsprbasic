package com.thc.fallsprbasic.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class User {
    @Id
    Integer num;
    String name;
    String password;
    String age;


}
