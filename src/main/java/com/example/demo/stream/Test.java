package com.example.demo.stream;

import com.example.demo.entity.UserPo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 题目要求：一分钟内完成此题，只能用一行代码实现！
 * 现在有5个用户！筛选：
 * 1、ID必须是偶数
 * 2、年龄必须大于23岁
 * 3、用户名转为大写字母
 * 4、用户名字母倒着排序
 * 5、只输出一个用户！
 *
 * @author liminghao.
 * @date 2022/7/10
 * @time 14:29
 */
public class Test {
    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 22);
        User u3 = new User(3, "c", 23);
        User u4 = new User(4, "d", 24);
        User u5 = new User(6, "e", 25);

        List<User> list = Arrays.asList(u1, u2, u3, u4, u5);
//        List<User> list = new ArrayList<>();
//        list.add(u1);
//        list.add(u2);
//        list.add(u3);
//        list.add(u4);
//        list.add(u5);

        // Stream流
        list.stream().filter(user -> user.getId() % 2 == 0)
                .filter(user -> user.getAge() > 23)
                .map(user -> user.getName().toUpperCase())
                .sorted((uu1,uu2)-> uu2.compareTo(uu1))
                .limit(1)
                .forEach(System.out::println);
    }
}
