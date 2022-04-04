package test;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.example.demo.DemoApplication;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author liminghao.
 * @date 2022/1/10
 * @time 23:35
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DemoApplication.class })
public class WrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;


    @Test
    public void testUserService() {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("nick_name","管理员");
        hashMap.forEach((k, v) -> System.out.println(k + " " + v));

        List<User> userList = userMapper.selectByMap(hashMap);
        for (User user : userList) {
            System.out.println(user);
        }
    }

    /**
     * 模拟开发中组装条件情况
     */
    @Test
    public void testUser() {
        String username = "K";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), "username", username)
                .ge(ageBegin != null, "age", ageBegin)
                .le(ageEnd != null, "age", ageEnd);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 模拟开发中组装条件情况 优化 使用lambda表达式
     */
    @Test
    public void testUserLambdaQueryWrapper() {
        String username = "K";
        Integer ageBegin = 20;
        Integer ageEnd = 30;
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username), User::getUsername, username)
                .ge(ageBegin != null, User::getAge, ageBegin)
                .le(ageEnd != null, User::getAge, ageEnd);
        List<User> userList = userMapper.selectList(queryWrapper);
        userList.forEach(System.out::println);
    }

    /**
     * 组装 select语句 查询 用户名，昵称，年龄
     */
    @Test
    public void testUserMapper() {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.select(User::getUsername, User::getNickName, User::getAge);
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    /**
     *  将(年龄大于20并且用户名中包含有 i) 或邮箱为 null 的用户信息修改
     */
    @Test
    public void testUserUpdateWrapper() {
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("username", "CZ")
                .and(i -> i.gt("age", 20).or().isNull("avatar"));
        updateWrapper.set("username", "KS").set("avatar","http://www.baidu.com");
        int i = userMapper.update(null, updateWrapper);
        System.out.println(i);
    }


    @Test
    public void testUserQueryWrapper() {
        // 将(年龄大于20并且用户名中包含有 i) 或邮箱为 null 的用户信息修改
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20)
                .like("nick_name", "凯")
                .or()
                .isNull("avatar");

        User user = new User();
        user.setUsername("CZH");
        user.setNickName("楚子航");
        user.setAvatar("http://localhost:9090/files/a73");
        int i = userMapper.update(user, queryWrapper);
        System.out.println("result:" + i);
    }

    /**
     * 使用mybatis-plus service中的批量添加
     * 注意：该批量添加是循环添加，一条一条插入数据库
     */
    @Test
    public void testUserServiceSaveBatch() {
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            User user = new User();
            user.setNickName("ybc" + i);
            user.setAge(20 + i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }

    /**
     * 高效率批量添加
     */
    @Test
    public void testUserServiceInsertSelective() {
        ArrayList<User> list = new ArrayList<>();
        for (int i = 0; i <= 10; i++) {
            User user = new User();
            user.setUsername("ybc" + i);
            user.setPassword("ybc" + i);
            user.setNickName("ybc" + i);
            user.setVersion(1);
            user.setRole(1);
            user.setAge(1);
            user.setSex("ybc" + i);
            user.setAddress("ybc" + i);
            user.setAvatar("ybc" + i);
            BigDecimal value =new BigDecimal(10.511);
            user.setAccount(value);
            user.setScore("ybc" + i);
            user.setNo("ybc" + i);
            user.setDel(0);

            list.add(user);
        }
        userService.batchInsert(list);
    }


    @Test
    public void contextLoads() {
        // 查询username不为空的用户，并且密码不为空的用户，年龄大于等于12
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.isNotNull("username")
                .isNotNull("password")
                .ge("age",20);
        userMapper.selectList(wrapper).forEach(System.out::println);
    }

    @Test
    public void contextLoads2() {
        // 查询nickname 为张三
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("nick_name","张三");
        // 查询一个数据，查询多个结果使用 list 或者 map
        User user = userMapper.selectOne(wrapper);
        System.out.println(user);
    }

    @Test
    public void contextLoads3() {
        // 查询年龄 20~30 岁之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.between("age",20,30);
        Long count = userMapper.selectCount(wrapper);   // 查询结果数
        System.out.println(count);
    }

    // 模糊查询
    @Test
    public void contextLoads4() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        // 左和右  %i%
        userQueryWrapper.notLike("username","i")
                .likeRight("password","1");
        List<Map<String, Object>> maps = userMapper
                .selectMaps(userQueryWrapper);
        maps.forEach(System.out::println);
    }

    // 通过id进行排序
    @Test
    public void contextLoads5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 通过id进行排序
        wrapper.orderByDesc("id");

        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void contextLoads6() throws Exception {
        String name = "张三";
        if (StringUtils.isEmpty(name)) {
            throw new Exception("名字不能为空");
        }
        log.info("名字为；" + name);
    }

    @Test
    public void contextLoads7() throws Exception {
        try {
            int num = 10/0;
        } catch (Exception e) {
            throw new Exception("不合法");
        }
    }

}
