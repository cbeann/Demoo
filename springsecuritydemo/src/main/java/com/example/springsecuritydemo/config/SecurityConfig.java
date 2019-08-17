package com.example.springsecuritydemo.config;

import com.example.springsecuritydemo.service.MyUserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author CBeann
 * @create 2019-08-16 9:34
 * SpringSecurty核心配置
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 记住我功能实现
     */








    @Autowired
    private MyUserDetailService myUserDetailService;

    /**
     * 解决UsernameNotFoundException不能被捕获的问题
     */
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setHideUserNotFoundExceptions(false);
        provider.setUserDetailsService(myUserDetailService);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }


    /**
     * 配置密码加密器，可以自定义加密器，实现PasswordEncoder接口
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new MyPasswordEncoder();
    }

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Autowired
    private AuthenticationSuccessHandler authenticationSuccessHandler;


    @Autowired
    private AuthenticationFailureHandler authenticationFailureHandler;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //表单登陆
        http.formLogin()
                //http.httpBasic()//弹出框登陆
                //告诉系统自动定登陆页面
                .loginPage("/login")
                //告诉系统这个URL为登陆请求，系统会走登陆验证的过滤器
                .loginProcessingUrl("/authentication/form")//告诉系统登陆请求的url
                .successHandler(authenticationSuccessHandler)//自定义登陆成功处理
                .failureHandler(authenticationFailureHandler)//自定义登陆失败处理
                .and()
                .authorizeRequests()//下面是请求配置
                .antMatchers("/login").permitAll()//当访问此URL（/login）时不需要验证
                .anyRequest()//任何请求
                .authenticated()//都要认证
                .and().csrf().disable();


    }
}
