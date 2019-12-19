package com.imooc.demo.cglibproxy;

import com.imooc.demo.myinterface.MyAsyncInterface;

/**
 * @author CBeann
 * @create 2019-12-19 16:30
 */
public class MQService {

    @MyAsyncInterface
    public void setMessage(String messgae) {

        System.out.println("开始发送MQmessage--------->睡3秒");

        try {
            Thread.sleep(1000 * 3);
        } catch (Exception e) {

        }
        System.out.println("结束发送MQmessage<-------------");

    }
}
