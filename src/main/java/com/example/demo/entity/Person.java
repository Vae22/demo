package com.example.demo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author liminghao.
 * @date 2022/3/20
 * @time 21:21
 */
@Data
@NoArgsConstructor
public class Person {

    private String totalSize;
    private String totalPage;
    private String pageSize;
    private String retCode;
    private String currentPage;
    private String retMsg;
    private List<ListBean> list;

    @NoArgsConstructor
    @Data
    public static class ListBean {
        private String lastTime;
        private String accName;
        private String property;
        private String bankName;
        private String curCode;
        private String bal;
        private String bankAcc;
        private String accStatus;
        private String availBal;
        private String bankType;
        private String accNature;
        private String isOffine;
        private String accPurpose;
        private String registerDate;
        private String cancellDate;
        private String corpCode;
        private String corpName;
    }
}
