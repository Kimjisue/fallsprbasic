package com.thc.fallsprbasic.service;

import com.thc.fallsprbasic.domain.Board;
import com.thc.fallsprbasic.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface UserService {
    Map<String, Object> loginUser(Map<String, Object> params);
    Map<String, Object> updateUser(Map<String, Object> params);
    Map<String, Object> deleteUser(Integer id);
    List<User> listUser();
    User detailUser(Integer id);
}
