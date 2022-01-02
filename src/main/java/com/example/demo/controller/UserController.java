package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Resource
    UserMapper userMapper;
    @Resource
    CategoryMapper categoryMapper;

    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userService.getUserInfo(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = userService.deleteById(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@RequestBody User user) {
        int result = userService.update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(@RequestBody User user) {
        return userService.save1(user);
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<User> listUser() {
        return userService.selectAll();
    }

    @RequestMapping("/findAllUserIds")
    @ResponseBody
    public List<Integer> selectAllIds() {
        return userService.selectAllIds();
    }


    @GetMapping("findPage")
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if (StringUtils.isNotBlank(search)){
            wrapper.like(User::getNickName, search);
        }
        Page<User> userPage = userMapper.selectPage(new Page<>(pageNum, pageSize),wrapper);
        return Result.success(userPage);
    }

    @GetMapping("findAllUser")
    public List<User> findAllUser() {
       return userService.findAllUser();
    }



    @PostMapping
    public Result<?> save(@RequestBody Category category) {
        categoryMapper.insert(category);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Category category) {
        categoryMapper.updateById(category);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        categoryMapper.deleteById(id);
        return Result.success();
    }


    @GetMapping("selectUser")
    public List<User> selectUser() {
        return userMapper.selectList(null);
    }

    @PostMapping("save")
    public Result<?> save(@RequestBody User user) {
        int insert = userMapper.insert(user);
        return Result.success(insert);
    }

    @PutMapping("updateById")
    public Result<?> updateById(@RequestBody User user) {
        int i = userMapper.updateById(user);
        return Result.success(i);
    }
}
