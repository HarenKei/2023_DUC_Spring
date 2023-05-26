package com.example.db_practice.dao;

import com.example.db_practice.entity.User;

public interface UserDAO {
    User insertUser(User user);
    User selector(Long id);
    User updateUserName(Long id, String name) throws Exception;
    void deleteUser(Long id) throws Exception;
}
