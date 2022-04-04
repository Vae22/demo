package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Emp;
import com.example.demo.mapper.EmpMapper;
import com.example.demo.service.EmpService;
/**
 * @author liminghao.
 * @date 2022/3/19
 * @time 20:47
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

}
