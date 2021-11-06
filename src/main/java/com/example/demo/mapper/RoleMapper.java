package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
@Repository
public interface RoleMapper extends BaseMapper<Role> {


    List<Role> findAllRole();

}