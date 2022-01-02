package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
public interface UserService {

    public User getUserInfo(int id);

    public int deleteById(int id);

    public int update(User user);

    public User save1(User user);

    public List<User> selectAll();

    public List<Integer> selectAllIds();

    List<User> findAllUser();
}
