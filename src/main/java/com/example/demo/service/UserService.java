package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public User getUserInfo(int id);

    public int deleteById(int id);

    public int Update(User user);

    public User save(User user);

    public List<User> selectAll();

}
