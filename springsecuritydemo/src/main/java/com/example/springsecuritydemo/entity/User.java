package com.example.springsecuritydemo.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author CBeann
 * @create 2019-08-16 10:22
 */
public class User implements UserDetails {

    private String username;
    private String password;

    private List<String> permissions = new ArrayList<>();

    /**
     * 是否被冻结、账号锁定等等标志位
     */
    private int sign = 1;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", permissions=" + permissions +
                ", sign=" + sign +
                '}';
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getSign() {
        return sign;
    }

    public void setSign(int sign) {
        this.sign = sign;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }


    /**
     * 下边是接口的方法
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        StringBuffer stringBuffer = new StringBuffer("");
        for (String permission : permissions) {
            stringBuffer.append(permission + ",");
        }


        //permissions的格式为 damin,user,root(中间用逗号分开)
        String permissions = stringBuffer.substring(stringBuffer.length() - 1).toString();


        return AuthorityUtils.commaSeparatedStringToAuthorityList(permissions);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    //账号是否过期，true没有过期
    public boolean isAccountNonExpired() {
        //你的业务逻辑
        return true;
    }

    @Override
    //账号是否被锁定或者冻结,true为没有被冻结
    public boolean isAccountNonLocked() {
        //你的业务逻辑
        return true;
    }

    @Override
    //密码是否过期，true没有过期
    public boolean isCredentialsNonExpired() {
        //你的业务逻辑
        return true;
    }

    @Override
    //账号是否可用或者删除，true为没有被删除
    public boolean isEnabled() {
        //你的业务逻辑
        return true;
    }
}
