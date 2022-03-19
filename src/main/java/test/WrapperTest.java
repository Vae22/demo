package test;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Map;

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
        List<User> userList = userService.selectAll();
        for (User user : userList) {
            System.out.println(user);
        }
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
            e.printStackTrace();
        }
    }

}
