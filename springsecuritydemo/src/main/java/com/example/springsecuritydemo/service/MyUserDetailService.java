package com.example.springsecuritydemo.service;

import com.example.springsecuritydemo.dao.UserDao;
import com.example.springsecuritydemo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author CBeann
 * @create 2019-08-16 10:20
 */
@Component
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("登陆用户：" + username);

        //查询数据库
        User user = userDao.getUser(username);
        if(user==null){
            throw new UsernameNotFoundException("账号不存在：UsernameNotFoundException");
        }

        return user;

    }
}
