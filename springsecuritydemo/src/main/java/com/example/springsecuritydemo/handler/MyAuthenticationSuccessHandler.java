package com.example.springsecuritydemo.handler;


import com.example.springsecuritydemo.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CBeann
 * @create 2019-08-16 21:23
 */

@Component("myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {
        System.out.println("登陆成功----------MyAuthenticationSuccessHandler");
        System.out.println(authentication);
        //获取用户的信息
        User loginUser = (User) authentication.getPrincipal();
        //给用户法发个积分，做个记录等操作
        //XXXService.method1()


        //调用框架原来的跳转
        super.onAuthenticationSuccess(httpServletRequest, httpServletResponse, authentication);

    }
}
