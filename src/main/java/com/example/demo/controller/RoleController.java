package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.RoleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    RoleService roleService;
    @Autowired
    private RedisTemplate redisTemplate;


    @GetMapping("findAllRole")
    public List<Role> findAllRole() {
        List<Role> allRole = roleService.findAllRole();
        return allRole;
    }

    @PostMapping("/setValue")
    public String setValue(){
        //redisTemplate
        //opsForValue   操作字符串 类似String
        //opsForList    操作List  类似List
        //opsForSet
        //opsForHash
        //opsForZSet
        redisTemplate.opsForValue().set("myName","zhangsan");
        System.out.println(redisTemplate.opsForValue().get("myName"));
        return (String) redisTemplate.opsForValue().get("myName");
    }


    @PostMapping("/setName")
    public Result<String> setName() throws JsonProcessingException {
        User user = new User();
        user.setUsername("狂神");
        user.setNickName("kuangshen");
        String jsonUser = new ObjectMapper().writeValueAsString(user);
        redisTemplate.opsForValue().set("user",jsonUser);
        System.out.println(redisTemplate.opsForValue().get("user"));
        return Result.success("添加成功");
    }

}
