package com.example.springsecuritydemo.handler;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author CBeann
 * @create 2019-08-17 9:32
 */
@Component("myAuthenticationFailureHandler")
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {


        //不同的异常会有不同的信息，比如账号不存在、密码错误（坏的凭证）、账号不可用等等
        String message = exception.getMessage();



        //将错误信息回显到登陆页面
        request.setAttribute("msg", message);
        request.getRequestDispatcher("/login").forward(request, response);

//        response.setContentType("application/json;charset=UTF-8");
//        response.getWriter().write("登陆失败："+message);


    }
}
