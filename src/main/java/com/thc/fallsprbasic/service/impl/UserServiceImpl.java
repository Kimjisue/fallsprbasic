package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.Board;
import com.thc.fallsprbasic.domain.User;
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
    public Map<String, Object> create(Map<String, Object> params) {
        System.out.println("create");
        Map<String, Object> result = new HashMap<String, Object>();

        String username = (String) params.get("username");
        User user = userRepository.findByUsername(username);
        if(user == null){
            user = new User();
            user.setUsername((String) params.get("username"));
            user.setPassword((String) params.get("password"));
            user.setName((String) params.get("name"));
            user.setPhone((String) params.get("phone"));
            user = userRepository.save(user);

            result.put("id", user.getId());
        } else {
            result.put("id duplicated", user.getUsername());
        }
        return result;
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
    public Map<String, Object> login(Map<String, Object> params) {
        Map<String, Object> result = new HashMap<>();

        String username = params.get("username") + "";//사용자가 프론트에서 던진 아이디
        String password = params.get("password") + "";//사용자가 프론트에서 던진 비밀번호
        //이렇게 적어줄 수도 있음 - string으로 변환해주는 이유는 map에서 형이 object이니깐
        //String username = (String)params.get("username") ;


        //1번째 방법
//        User user = userRepository.findByUsername(username); // 사용자가 던진 아이디로 조회한 데이터베이스에 담긴 진짜 사용자 정보임
//        //여기까지 왔으면 아이디는 정상적인 것
//        if(user ==null){
//            result.put("resultCode",400);
//            return result;
//        }
//
//        String password_real = user.getPassword();
//
//        if(password.equals(password_real)) {
//            //사용자 입력 값이랑 진짜 비번이랑 동일 => 로그인 성공
//            result.put("resultCode",200);
//            return result;
//        }else{
//            result.put("resultCode",400);
//            return result;
//        }
        //2번째 방법
        User user2 = userRepository.findByUsernameAndPassword(username,password);
        if(user2 != null){
            result.put("resultCode",200);
            return result;
        }
        return null;

    }
    @Override
    public Map<String, Object> signup(Map<String, Object> params) {
        System.out.println("signup");
        Map<String, Object> result = new HashMap<String, Object>();
///사용자가 입력한 username 받아오기
        String username = (String) params.get("username");
        //String password = (String) params.get("password");
        //repository에 저장되어있는 username 가져온다
        User user = userRepository.findByUsername(username);
        if(user == null){
            user = new User();
            user.setUsername((String) params.get("username"));
            user.setPassword((String) params.get("password"));
            user.setName((String) params.get("name"));
            user.setPhone((String) params.get("phone"));
            user = userRepository.save(user);
    //save로 repository에 저장해준다
            result.put("id", user.getId());
        } else {
            result.put("id duplicated", user.getUsername());
        }
        return result;
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