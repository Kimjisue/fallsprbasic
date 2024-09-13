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
    public Map<String, Object> loginUser(Map<String, Object> params) {
        System.out.println("createUser");
        User user = new User();
        user.setNum(Integer.parseInt(params.get("num")+ ""));;
        user.setName(params.get("name").toString());
        user.setPassword(params.get("password").toString());
        user.setAge(params.get("age").toString());
        userRepository.save(user);
        return null;
    }
    @Override
    public Map<String, Object> updateUser(Map<String, Object> params) {
        System.out.println("updateBoard");
        User user = userRepository.findById(Integer.parseInt(params.get("num") + "")).orElseThrow(() -> new RuntimeException(""));

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
    public User detailUser(Integer num) {
        return userRepository.findById(num).orElseThrow(() -> new RuntimeException(""));
    }
    @Override
    public Map<String, Object> deleteUser(Integer num) {
        User user = userRepository.findById(num).orElseThrow(() -> new RuntimeException(""));
        userRepository.delete(user);
        return null;
    }

}
