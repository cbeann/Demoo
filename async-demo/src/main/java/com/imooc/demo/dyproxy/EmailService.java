package com.imooc.demo.dyproxy;

import com.imooc.demo.myinterface.MyAsyncInterface;

/**
 * @author CBeann
 * @create 2019-12-18 22:40
 */

public class EmailService implements IEmailService {

    @MyAsyncInterface
    @Override
    public void sendEmail() {
        System.out.println("开始发送email---------->睡10秒");

        try {
            //处理业务10毫秒
            Thread.sleep(1000 * 2);
        } catch (Exception e) {

        }

        System.out.println("结束发发送email<----------");
    }

    public void speak() {
        System.out.println("-----EmailService------");
    }
}
