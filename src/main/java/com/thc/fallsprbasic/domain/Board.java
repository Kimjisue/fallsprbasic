package com.thc.fallsprbasic.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//entity가 필요한건 Dao 중에 repository
@Setter
@Getter
@Entity
public class Board {
    @Id
    Integer id;
    String title;
    String content;
    String author;


}
