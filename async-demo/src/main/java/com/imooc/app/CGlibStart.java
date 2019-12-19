package com.imooc.app;

import com.imooc.demo.cglibproxy.CGlibProxy;
import com.imooc.demo.cglibproxy.MQService;

/**
 * @author CBeann
 * @create 2019-12-19 16:39
 */
public class CGlibStart {
    public static void main(String[] args) {

//        MQService mqService = new MQService();
//        mqService.setMessage("123123");

        CGlibProxy cGlibProxy = new CGlibProxy();
        MQService proxy = (MQService) cGlibProxy.getProxy(MQService.class);
        proxy.setMessage("123");
        System.out.println("-----------------------");


//        执行结果
//        -----------------------             System.out.println("-----------------------");
//        开始发送MQmessage--------->睡3秒     proxy.setMessage("123");
//        结束发送MQmessage<-------------
    }
}
