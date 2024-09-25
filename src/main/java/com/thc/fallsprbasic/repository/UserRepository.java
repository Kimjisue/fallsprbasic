package com.thc.fallsprbasic.repository;


import com.thc.fallsprbasic.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
}

//JpaRepository 를 상속한다면 findall 쓸 수 있다.