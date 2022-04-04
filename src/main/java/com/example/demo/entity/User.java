package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
@TableName("user")
public class User implements Serializable {

    /**
     * ID
     */
    @ApiModelProperty(value="ID")
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value="用户名")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value="密码")
    private String password;

    /**
     * 昵称
     */
    @ApiModelProperty(value="昵称")
    private String nickName;

    /**
     * 乐观锁
     */
    @ApiModelProperty(value="乐观锁")
    @Version
    private Integer version;

    /**
     * 角色，1：管理员，2：普通用户
     */
    @ApiModelProperty(value="角色，1：管理员，2：普通用户")
    private Integer role;

    /**
     * 年龄
     */
    @ApiModelProperty(value="年龄")
    private Integer age;

    /**
     * 性别
     */
    @ApiModelProperty(value="性别")
    private String sex;

    /**
     * 地址
     */
    @ApiModelProperty(value="地址")
    private String address;

    /**
     * 头像
     */
    @ApiModelProperty(value="头像")
    private String avatar;

    /**
     * 账户余额
     */
    @ApiModelProperty(value="账户余额")
    private BigDecimal account;

    /**
     * 分数
     */
    @ApiModelProperty(value="分数")
    private String score;

    /**
     * 学号
     */
    @ApiModelProperty(value="学号")
    private String no;

    /**
     * 创建时间 字段添加填充内容
     */
    @ApiModelProperty(value="创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty(value="更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除
     */
    @ApiModelProperty(value="逻辑删除")
    @TableLogic(value = "0",delval = "1")
    private Integer del;

    // @TableField注解用于实体类中不存在的字段，如果不加该注解，则会报错。
    @TableField(exist = false)
    private List<Account> accounts;

}
