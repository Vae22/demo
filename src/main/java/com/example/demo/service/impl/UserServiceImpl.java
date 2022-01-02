package com.example.demo.service.impl;


import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserInfo(int id) {
        return userMapper.getUserInfo(id);
    }


    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public User save1(User user1) {
        int save = userMapper.save1(user1);
        return user1;
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public List<Integer> selectAllIds(){
        List<User> userList =  userMapper.selectAll();
        // 方法1
        List<Integer> userIdList = new ArrayList<>();
        for (User user:userList
        ) {
            userIdList.add(user.getId());
        }
        // 方法2
        List<Integer> userIdList1=userList.stream().map(User::getId).collect(Collectors.toList());
        return userIdList1;
    }

    @Override
    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }


//    public int insert(User user) {
//        return userMapper.insert(user);
//    }

}
