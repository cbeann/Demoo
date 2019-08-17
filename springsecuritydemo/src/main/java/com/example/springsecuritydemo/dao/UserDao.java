package com.example.springsecuritydemo.dao;

import com.example.springsecuritydemo.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author CBeann
 * @create 2019-08-16 10:21
 */
@Repository
public class UserDao {

    public static Map<String, User> users = new HashMap<>();

    static {
        //初始化数据，假装自己查数据库
        User user = new User("zhangsan", "123456");
        user.setPermissions(Arrays.asList("admin", "user"));
        User user2 = new User("lisi", "123456");
        user2.setPermissions(Arrays.asList("user"));
        users.put(user.getUsername(), user);
        users.put(user2.getUsername(), user2);


    }


    public User getUser(String username) {
        return users.getOrDefault(username,null);

    }

}
