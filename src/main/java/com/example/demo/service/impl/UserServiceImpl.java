package com.example.demo.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

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
    public int update1(User user) {
        return userMapper.update1(user);
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
        for (User user:userList) {
            userIdList.add(user.getId());
        }
        // 方法2
        List<Integer> userIdList1 = userList.stream().map(User::getId).collect(Collectors.toList());
        return userIdList1;
    }

    @Override
    public List<User> findAllUser() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        return userMapper.selectList(queryWrapper);
    }

    @Override
    public int batchInsert(List<User> list) {
        return userMapper.batchInsert(list);
    }


//    public int insert(User user) {
//        return userMapper.insert(user);
//    }

}
