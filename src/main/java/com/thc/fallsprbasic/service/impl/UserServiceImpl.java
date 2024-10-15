package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.Board;
import com.thc.fallsprbasic.domain.User;
import com.thc.fallsprbasic.dto.UserDto;
import com.thc.fallsprbasic.repository.BoardRepository;
import com.thc.fallsprbasic.repository.UserRepository;
import com.thc.fallsprbasic.service.BoardService;
import com.thc.fallsprbasic.service.UserService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(
            UserRepository userRepository
    ) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto.CreateResDto create(UserDto.CreateReqDto param) {
        System.out.println("create");
        UserDto.CreateResDto result = new UserDto.CreateResDto();
        Long id = null;
        String username = param.getUsername();
        User user = userRepository.findByUsername(username);
//        if(user == null){
//            user = new User();
//            user.setUsername(username);
//            user.setPassword(param.getPassword());
//            user.setName(param.getName());
//            user.setPhone(param.getPhone());
//            user = userRepository.save(user);
//
//            //id = user.getId();
//            result.setId(user.getId());
//        } else {
//            result.setId((long)0);
//            // 0으로 오면 가입이 안된다고 생각하면 됨
//
//        }

        //toEntity 덕분에 아래와 같이 사용 가능
//        if(user == null){
//            user = userRepository.save(param.toEntity());
//            //id = user.getId();
//            result.setId(user.getId());
//            return user.toCreateResDto();
//        } else {
//            result.setId((long)0);
//            // 0으로 오면 가입이 안된다고 생각하면 됨
//            return result;
//        }
        if(user != null){
            throw new RuntimeException("id exist");
        }
        user = userRepository.save(param.toEntity());
//            //id = user.getId();
            result.setId(user.getId());
            return user.toCreateResDto();
    }
    @Override
    public Map<String, Object> update(Map<String, Object> params) {
        System.out.println("update");
        User user = userRepository.findById(Long.parseLong(params.get("id") + "")).orElseThrow(() -> new RuntimeException(""));
        if(params.get("username") != null) {
            user.setUsername((String) params.get("username"));
        }
        if(params.get("password") != null) {
            user.setPassword((String) params.get("password"));
        }
        if(params.get("name") != null) {
            user.setName((String) params.get("name"));
        }
        if(params.get("phone") != null) {
            user.setPhone((String) params.get("phone"));
        }
        userRepository.save(user);
        return null;
    }
    @Override
    public List<User> list() {
        return userRepository.findAll();
    }
    @Override
    public User detail(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }
    @Override
    public Map<String, Object> delete(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        userRepository.delete(user);
        return null;
    }

    @Override
    public UserDto.LoginResDto login(UserDto.LoginReqDto param) {
        UserDto.LoginResDto result = new UserDto.LoginResDto();


        String username = param.getUsername();//사용자가 프론트에서 던진 아이디
        String password = param.getPassword();//사용자가 프론트에서 던진 비밀번호
        User user = userRepository.findByUsernameAndPassword(username,password);

            if(user == null){
                throw new RuntimeException("wrong");
            }
        if(user != null){
            //로그인 성공 !
            UserDto.LoginResDto res = new UserDto.LoginResDto();
            //res.setResult(true);
            res.setId(user.getId());
            return res;
        }
        return null;

    }
    @Override
    public UserDto.CreateResDto signup(UserDto.CreateReqDto param) {
        System.out.println("signup");
        if(param.getUsername() == null || param.getPassword() == null || param.getName()==null || param.getPhone() == null){
            throw new RuntimeException("not enough parameters");
        }
        return create(param);
        //return create(params);
        //create랑 내용 똑같으니깐 create return 해준거임
    }

    @Override
    public boolean id(String username) {
        User user = userRepository.findByUsername(username);
        if(user == null){
            return true;
        }
        return false;
    }




}