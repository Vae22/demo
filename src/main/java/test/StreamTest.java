package test;


import com.example.demo.entity.UserPo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author liminghao.
 * @date 2022/6/29
 * @time 16:27
 */
public class StreamTest {
    public static void main(String[] args) {
        List<UserPo> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new UserPo("张三" + i, "1"));
        }
        // filter 过滤
        long count = list.stream().filter(p -> p.getScore() != null).count();
        System.out.println("成绩不为空的学生人数:" + count);

        // map 映射 取出所有学生的成绩
        List<String> scoreList = list.stream().map(UserPo::getScore).collect(Collectors.toList());
        scoreList.forEach(s -> System.out.println(s));

        // 将学生姓名集合串成字符串，用逗号分隔
        String s = list.stream().map(UserPo::getName).collect(Collectors.joining(","));
        System.out.println(s);

    }

}
