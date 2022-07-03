package com.example.demo.entity;

import lombok.Data;

/**
 * @author liminghao.
 * @date 2022/6/29
 * @time 16:29
 */
@Data
public class UserPo {
    private String name;
    private String score;

    public UserPo(String name, String score) {
        this.name = name;
        this.score = score;
    }
}
