package com.example.demo.mapper;

import com.example.demo.entity.Account;

import java.util.List;

/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
public interface AccountMapper {


    /**
     * 查询所有账户
     * @Author Mr.Li
     * @Date 14:03 2021/10/16
     * @Param []
     * @return java.util.List<com.example.demo.entity.Account>
     **/
    List<Account> findAll();

}
