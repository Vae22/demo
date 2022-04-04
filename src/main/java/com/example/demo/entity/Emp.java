package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author liminghao.
 * @date 2022/3/19
 * @time 20:47
 */
@ApiModel(value="com-example-demo-entity-Emp")
@Data
@TableName(value = "emp")
public class Emp {
    /**
     * 主键
     */
    @TableId(value = "emp_id", type = IdType.INPUT)
    @ApiModelProperty(value="主键")
    private String empId;

    /**
     * 姓名
     */
    @TableField(value = "emp_name")
    @ApiModelProperty(value="姓名")
    private String empName;

    /**
     * 年龄
     */
    @TableField(value = "user_age")
    @ApiModelProperty(value="年龄")
    private String userAge;

}
