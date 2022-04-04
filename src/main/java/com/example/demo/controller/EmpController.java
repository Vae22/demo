package com.example.demo.controller;

import com.example.demo.entity.Emp;
import com.example.demo.entity.User;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author liminghao.
 * @date 2022/3/19
 * @time 21:53
 */
@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    EmpService empService;
    @Autowired
    EmpMapper empMapper;

    @PostMapping("testEmp")
    public boolean testEmp(@RequestBody Emp emp) {
        boolean insert = empService.saveOrUpdate(emp);
        if (insert) {
            log.info("添加成功");
            return true;
        }else {
            log.info("添加失败");
            return false;
        }
    }

}
