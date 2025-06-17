package com.example.demo.dao.api;


import com.example.demo.dao.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserStorage extends JpaRepository<UserEntity, String> {
    @Query ("SELECT u.name FROM UserEntity u where u.nickname = :nickname")
    String findNameByNickname(String nickname);
}
