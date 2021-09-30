package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public User GetUser(@PathVariable int id) {
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
        int result = userService.Update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping("/findAll")
    @ResponseBody
    public List<User> ListUser() {
        return userService.selectAll();
    }

    @RequestMapping("/findAllUserIds")
    @ResponseBody
    public List<Integer> selectAllIds() {
        return userService.selectAllIds();
    }
}
