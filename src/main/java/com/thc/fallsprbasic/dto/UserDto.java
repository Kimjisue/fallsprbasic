package com.thc.fallsprbasic.dto;

import com.thc.fallsprbasic.domain.Notice;
import com.thc.fallsprbasic.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

public class UserDto {
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateReqDto extends DefaultDto.CreateReqDto{
        private Long id;
        private String username;
        private String password;
        private String name;
        private String phone;


        public User toEntity() {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setName(name);
            user.setPhone(phone);
            return user;
        }//DTO 에서 Entity로 변환해서 보내므로 Service에서 굳이 또 만들 필요 없음
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class CreateResDto{
        private Long id;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class SignupReqDto {
        private Long id;
        private String username;
        private String password;
        private String name;
        private String phone;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class LoginResDto {
       // private boolean result;
        private Long id;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class LoginReqDto {
        private String username;
        private String password;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class SignupResDto {
        private Long id;
    }

    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class UpdateReqDto extends DefaultDto.UpdateReqDto{
        private Long id;
        private String name;
        private String phone;
    }

    @AllArgsConstructor @NoArgsConstructor @Setter @Getter
    public static class DetailResDto extends DefaultDto.DetailResDto{
        private Long id;
        private String name;
        private String phone;
        private String username;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @SuperBuilder
    @Setter @Getter
    public static class ListReqDto extends DefaultDto.ListReqDto{
        private String title;
    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class PagedListReqDto extends DefaultDto.PagedListReqDto{
        private Boolean deleted;
        private String title;

    }
    @AllArgsConstructor @NoArgsConstructor @SuperBuilder @Setter @Getter
    public static class ScrollListReqDto extends DefaultDto.ScrollListReqDto{
        private String title;
    }

}
