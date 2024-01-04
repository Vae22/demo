package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.Result;
import com.example.demo.entity.Category;
import com.example.demo.entity.User;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author liminghao.
 * @date 2021/10/16
 * @time 12:02
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    UserMapper userMapper;
    @Autowired
    CategoryMapper categoryMapper;

    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable int id) {
        return userService.getUserInfo(id);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = userService.deleteById(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update1(@RequestBody User user) {
        int result = userService.update1(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }

    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public User insert(@RequestBody User user) {
        return userService.save1(user);
    }

    @RequestMapping("/selectAll")
    @ResponseBody
    public List<User> listUser() {
        return userService.selectAll();
    }

    @RequestMapping("/findAllUserIds")
    @ResponseBody
    public List<Integer> selectAllIds() {
        return userService.selectAllIds();
    }


    @GetMapping("findPage")
    public Result<?> findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                              @RequestParam(defaultValue = "10") Integer pageSize,
                              @RequestParam(defaultValue = "") String search){
        LambdaQueryWrapper<User> wrapper = Wrappers.<User>lambdaQuery();
        if (StringUtils.isNotBlank(search)){
            wrapper.like(User::getNickName, search);
        }
        Page<User> userPage=  userMapper.selectPage(new Page<>(pageNum, pageSize), wrapper);
        return Result.success(userPage);
    }

    @GetMapping("findAllUser")
    public List<User> findAllUser() {
       return userService.findAllUser();
    }


    @PostMapping
    public Result<?> save(@RequestBody Category category) {
        categoryMapper.insert(category);
        return Result.success();
    }

    @PutMapping
    public Result<?> update(@RequestBody Category category) {
        categoryMapper.updateById(category);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable Integer id) {
        categoryMapper.deleteById(id);
        return Result.success();
    }

    /**
     * 多线程测试
     * @return
     * @throws InterruptedException
     * @throws ExecutionException
     */
    @GetMapping("selectUser")
    public List<User> selectUser() throws InterruptedException, ExecutionException {
        List<User> users = new ArrayList<>();

        ExecutorService executorService = Executors.newCachedThreadPool();
        CompletionService<List<User>> cs = new ExecutorCompletionService<>(executorService);
        for (int i = 0; i < 5; i++) {
            Callable callable = new Callable<List<User>>() {
                @Override
                public List<User> call() throws Exception {
                    System.out.println("当前线程名称:\n" + Thread.currentThread().getName());
                    // 封装的调用接口的方法
//                    List<User> userList = userMapper.selectList(null);
//                    List<User> userList1 = userMapper.selectAll();
//                    users.addAll(userList);
//                    users.addAll(userList1);
                    Thread.sleep(1000);
                    System.out.println("睡眠1秒");
                    return users;
                }
            };
            cs.submit(callable);
        }
        List<User> list = cs.take().get();
//        for (User o : users) {
//            System.out.println("遍历集合中的数据:\n" + o);
//        }

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                // 封装的调用接口的方法
//                List<User> userList = userMapper.selectList(null);
//                List<User> userList1 = userMapper.selectAll();
//                users.addAll(userList);
//                users.addAll(userList1);
//            }
//        });
//        executorService.submit(thread);
        return list;
    }

    @PostMapping("save")
    public Result<?> save(@RequestBody User user) {
        int insert = userMapper.insert(user);
        return Result.success(insert);
    }

    @PutMapping("updateById")
    public Result<?> updateById(@RequestBody User user) {
        int i = userMapper.updateById(user);
        return Result.success(i);
    }

}
