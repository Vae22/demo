package com.example.demo.service;


import com.example.demo.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
public interface RoleService {

    /**
     * 查询所有角色
     * @Author Mr.Li
     * @Date 14:09 2021/10/16
     * @Param []
     * @return java.util.List<com.example.demo.entity.Role>
     **/
    List<Role> findAllRole();

}
