package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@TableName("user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String username;
    private String password;
    private String nickName;
    private Integer age;
    private String sex;
    private String address;

    @Version  // 乐观锁Version注解
    private Integer version;

    // @TableField注解用于实体类中不存在的字段，如果不加该注解，则会报错。
    @TableField(exist = false)
    private List<Account> accounts;

    //字段添加填充内容
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

//    @TableLogic(value = "1",delval = "0")  //逻辑删除
//    private Integer del;
}
