package test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.entity.UserPo;

import java.util.*;
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
            list.add(new UserPo("张三" + i, ""+i));
            list.add(new UserPo("李四" + i, ""+i));
        }
        // filter 过滤
        long count = list.stream().filter(userPo -> userPo.getScore() != null).count();
        System.out.println("成绩不为空的学生人数:" + count);

        // map 映射 取出所有学生的成绩
        List<String> scoreList = list.stream().map(UserPo::getScore).collect(Collectors.toList());
//        scoreList.forEach(s -> System.out.println(s));

        // 将学生姓名集合串成字符串，用逗号分隔
        String s = list.stream().map(UserPo::getName).collect(Collectors.joining(","));
        System.out.println(s);

        // 按学生成绩逆序排序 正序则不需要加 .reversed()
        List<UserPo> filterList = list.stream().filter(userPo -> userPo.getScore() != null)
                .sorted(Comparator.comparing(UserPo::getScore).reversed())
                .collect(Collectors.toList());
        // forEach 最经常使用，为每一个元素进行自定义操作
        filterList.stream().forEach(userPo -> userPo.setScore(
                String.valueOf(Integer.parseInt(userPo.getScore()) + 10)));

        // collect: 聚合，可以用于GroupBy按指定字段分类，也可以用于返回列表或者拼凑字符串
        Map<String, List<UserPo>> listMap = list.stream().filter(userPo -> userPo.getScore() != null)
                .collect(Collectors.groupingBy(UserPo::getScore));
        listMap.forEach((score, userPos) -> System.out.println("成绩:"+score+"人数:" + userPos.size()));

        // statistics: 统计，可以统计中位数，平均值，最大最小值
        DoubleSummaryStatistics statistics =
                filterList.stream().mapToDouble(value -> Double.parseDouble(value.getScore()))
                        .summaryStatistics();
        System.out.println("列表中最大的数:" + statistics.getMax());
        System.out.println("列表中最小的数:" + statistics.getMin());
        System.out.println("所有数之和:" + statistics.getSum());
        System.out.println("平均数:" + statistics.getAverage());

        QueryWrapper<UserPo> wrapper = new QueryWrapper<>();


        // 并行流
        list.parallelStream().filter(userPo -> userPo.getScore() != null).count();
        System.out.println("并行流处理参加考试的学生人数:"+count);
    }

}
