package com.thc.fallsprbasic.dto;

import com.thc.fallsprbasic.domain.Notice;
import lombok.*;

public class NoticeDto {
    // class 안에 왜 또 다른 class 가 있냐면 create , update 등등 보기 편하게 만들거라서 ..?
    @Setter
    @Getter
    public static class CreateReqDto {
        private String title;
        private String content;


        public Notice toEntity() {
            Notice notice = new Notice();
            notice.setTitle(title);
            notice.setContent(content);
            return notice;
        }//DTO 에서 Entity로 변환해서 보내므로 Service에서 굳이 또 만들 필요 없음
    }

    @Setter
    @Getter
    public static class UpdateReqDto{
        private Long id;
        private String title;
        private String content;
    }

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

    @Setter
    @Getter
    public static class ListReqDto {
        private String title;
    }

}
