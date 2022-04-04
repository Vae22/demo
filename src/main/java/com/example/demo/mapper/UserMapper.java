package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id查询用户信息
     * @param id
     * @return
     */
    User getUserInfo(int id);
    /**
     * 新增用户
     * @param user
     * @return
     */
    int save1 (User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    int update1 (User user);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    int deleteById (int id);

    /**
     * 查询所有用户信息
     * @return
     */
    List<User> selectAll ();

    List<User> findAllUser();

    int batchInsert(@Param("list") List<User> list);
}
