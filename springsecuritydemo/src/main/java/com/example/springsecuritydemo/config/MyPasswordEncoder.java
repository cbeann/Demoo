package com.example.springsecuritydemo.config;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author CBeann
 * @create 2019-08-16 15:57
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {//加密算法,此处没有加密
        String str = charSequence.toString();
        return str;
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {

        String target = charSequence.toString();
        if (target != null && s != null && target.equals(s)) {
            System.out.println("登陆成功");
            return true;
        }
        System.out.println("登陆失败");
        return false;
    }
}
