package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Account;
import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;
    @Resource
    CategoryMapper categoryMapper;

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<Account> listAccount() {
        return accountService.findAll();
    }

    @GetMapping
    public Result<?> findChildren() {
        List<Category> categories = categoryMapper.selectList(null);
        return Result.success(queryChildren(null, categories));
    }

    private List<Category> queryChildren(Integer pid, List<Category> categories) {
        List<Category> categoryList = new ArrayList<>();
        for(Category category : categories) {
            if (pid == null) {
                if (category.getPid() == null) {
                    categoryList.add(category);
                    category.setChildren(queryChildren(category.getId(), categories));
                }
            } else if (pid.equals(category.getPid())) {
                categoryList.add(category);
                category.setChildren(queryChildren(category.getId(), categories));
            }
        }
        return categoryList;
    }

}
