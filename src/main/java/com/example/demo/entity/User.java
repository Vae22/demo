package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class User implements Serializable {
    private Integer id;
    private String userName;
    private Date birthDay;
    private String sex;
    private String address;
    private List<Account> accounts;

}
