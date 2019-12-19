package com.imooc.app;

import com.imooc.demo.dyproxy.EmailService;
import com.imooc.demo.dyproxy.IEmailService;
import com.imooc.demo.dyproxy.MyAsyncHandler;

import java.lang.reflect.Proxy;

/**
 * @author CBeann
 * @create 2019-12-19 14:51
 */
public class ProxyStart {
    public static void main(String[] args) {

        IEmailService emailService = new EmailService();
        MyAsyncHandler asyncHandler = new MyAsyncHandler(emailService);
        Class cls = emailService.getClass();

        //创建动态代理对象
        IEmailService newProxyInstance = (IEmailService) Proxy.newProxyInstance(
                cls.getClassLoader(), cls.getInterfaces(), asyncHandler);

        //此方法时异步
        newProxyInstance.sendEmail();
        //此方法时同步
        newProxyInstance.speak();

//        执行结果如下：
//        -----EmailService------      newProxyInstance.speak()方法
//        开始发送email---------->睡10秒    newProxyInstance.sendEmail();方法
//        结束发发送email<----------

    }
}
