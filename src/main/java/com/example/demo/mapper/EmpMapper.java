package com.example.demo.mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.Emp;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liminghao.
 * @date 2022/3/19
 * @time 20:47
 */
@Mapper
public interface EmpMapper extends BaseMapper<Emp> {

    List<Emp> selectAllByEmpName(@Param("empName")String empName);

    /**
     * 批量添加
     * @param list
     * @return
     */
    int insertList(@Param("list")List<Emp> list);

}
