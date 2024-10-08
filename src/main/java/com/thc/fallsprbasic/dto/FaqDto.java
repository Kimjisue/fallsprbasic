package com.thc.fallsprbasic.dto;

import com.thc.fallsprbasic.domain.Faq;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

public class FaqDto {
    // class 안에 왜 또 다른 class 가 있냐면 create , update 등등 보기 편하게 만들거라서 ..?
    @Builder
    @Setter
    @Getter
    public static class CreateReqDto {
        private String title;
        private String content;


        public Faq toEntity() {
            return Faq.of(getTitle(), getContent());
        }
    }

    @Setter
    @Getter
    public static class UpdateReqDto{
        private Long id;
        private String title;
        private String content;
    }
    @Builder
    @Setter
    @Getter
    public static class CreateResDto{
        private Long id;
    }

    @Setter
    @Getter
    public static class DetailResDto {
        private Long id;
        private String title;
        private String content;
    }

}
