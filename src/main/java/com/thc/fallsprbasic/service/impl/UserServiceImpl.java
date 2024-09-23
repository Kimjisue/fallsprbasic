package com.thc.fallsprbasic.service.impl;

import com.thc.fallsprbasic.domain.User;
import com.thc.fallsprbasic.repository.UserRepository;
import com.thc.fallsprbasic.service.UserService;
import org.springframework.stereotype.Service;

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
    public Map<String, Object> createUser(Map<String, Object> params) {
        System.out.println("createUser");
        User user = new User();
        user.setId(Long.parseLong(params.get("id") + ""));
        //user.setUsername((String)(params.get("username"));
        user.setNum(params.get("num").toString());
        user.setName(params.get("name").toString());
        user.setPassword(params.get("password").toString());
        user.setAge(params.get("age").toString());
        user = userRepository.save(user);

        //Map<String,Object>
        return null;
    }
    @Override
    public Map<String, Object> updateUser(Map<String, Object> params) {
        System.out.println("updateBoard");
        User user = userRepository.findById(Long.parseLong(params.get("id") + "")).orElseThrow(() -> new RuntimeException(""));
        //user.setNum(Integer.parseInt(params.get("id")+ ""));
        user.setName(params.get("num").toString());
        user.setName(params.get("name").toString());
        user.setPassword(params.get("password").toString());
        user.setAge(params.get("age").toString());
        userRepository.save(user);
        return null;
    }
    @Override
    public List<User> listUser() {
        return userRepository.findAll();
    }
    @Override
    public User detailUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
    }
    @Override
    public Map<String, Object> deleteUser(Long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        userRepository.delete(user);
        return null;
    }

}
