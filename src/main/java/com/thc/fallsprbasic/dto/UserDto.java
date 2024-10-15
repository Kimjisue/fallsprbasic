package com.thc.fallsprbasic.dto;

import com.thc.fallsprbasic.domain.Notice;
import com.thc.fallsprbasic.domain.User;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

public class UserDto {
    @Setter
    @Getter
    public static class CreateReqDto {
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
    @Setter
    @Getter
    public static class CreateResDto{
        private Long id;
    }
    @Setter
    @Getter
    public static class SignupReqDto {
        private Long id;
        private String username;
        private String password;
        private String name;
        private String phone;
    }
    @Setter
    @Getter
    public static class LoginResDto {
       // private boolean result;
        private Long id;
    }
    @Setter
    @Getter
    public static class LoginReqDto {
        private String username;
        private String password;
    }
    @Setter
    @Getter
    public static class SignupResDto {
        private Long id;
    }

    @Setter
    @Getter
    public static class UpdateReqDto{
        private Long id;
        private String name;
        private String phone;
    }

}
