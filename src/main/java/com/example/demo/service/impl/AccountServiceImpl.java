package com.example.demo.service.impl;

import com.example.demo.entity.Account;
import com.example.demo.mapper.AccountMapper;
import com.example.demo.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountMapper accountMapper;

    /**
     * 查询所有账户
     * @Author Mr.Li
     * @Date 14:05 2021/10/16
     * @Param []
     * @return java.util.List<com.example.demo.entity.Account>
     **/
    @Override
    public List<Account> findAll() {
        return accountMapper.findAll();
    }
}
