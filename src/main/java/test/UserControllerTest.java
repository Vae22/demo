package test;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.DemoApplication;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.testng.annotations.AfterTest;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author liminghao.
 * @date 2022/1/5
 * @time 16:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { DemoApplication.class })
public class UserControllerTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void getUser() {
        List<User> userList = userMapper.selectList(null);
        userList.forEach(System.out::println);
    }

    @Test
    public void saveUser() {
        User user = new User();
        user.setUsername("路明非");
        user.setPassword("12345");
        int i = userMapper.insert(user);
        System.out.println("插入成功：" + i);
    }

    @Test
    public void updateUser() {
        User user = new User();
        // 通过条件自动拼接动态sql
        user.setId(37);
        user.setUsername("路明非");
        user.setPassword("666");

        // 注意：updateById 但是参数是一个 对象
        int i = userMapper.updateById(user);
        System.out.println("修改成功：" + i);
    }

    // 测试乐观锁成功
    @Test
    public void testOptimisticLocker() {
        // 1.查询用户信息
        User user = userMapper.selectById(39);
        // 2.修改用户信息
        user.setUsername("楚子航");
        user.setPassword("888");
        // 3.执行更新操作
        userMapper.updateById(user);
    }

    // 测试乐观锁失败！多线程下
    @Test
    public void testOptimisticLocker2() {
        // 线程1
        User user = userMapper.selectById(39);
        user.setUsername("楚子航111");
        user.setPassword("888");

        // 模拟另外一个线程执行了插入操作
        User user2 = userMapper.selectById(39);
        user2.setUsername("楚子航222");
        user2.setPassword("888");
        userMapper.updateById(user2);
        // 自旋锁来多次尝试提交
        userMapper.updateById(user); // 如果没有乐观锁就会覆盖插队线程的值！
    }

    // 测试查询
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(19);
        System.out.println(user);
    }

    // 测试批量查询
    @Test
    public void testSelectByBatchId() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    // 条件查询 map
    @Test
    public void testSelectByBatchIds() {
        HashMap<String, Object> map = new HashMap<>();
        // 自定义要查询
        map.put("username","路明非");
        map.put("age",11);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    // 测试分页
    @Test
    public void testPage() {
        // 参数一：当前页，参数二：页面大小
        Page<User> page = new Page<>(2,5);
        userMapper.selectPage(page,null);

        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    // 测试删除
    @Test
    public void testDeleteById() {
        int i = userMapper.deleteById(20);
    }

    // 测试批量删除
    @Test
    public void testDeleteBatchId() {
        int i = userMapper.deleteBatchIds(Arrays.asList(35,36));
    }

    // 通过map删除
    @Test
    public void testDeleteByMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("username","z3");
        userMapper.deleteByMap(map);
    }
}

