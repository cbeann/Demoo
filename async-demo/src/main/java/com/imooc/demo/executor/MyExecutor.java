package com.imooc.demo.executor;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.concurrent.FutureTask;

/**
 * @author CBeann
 * @create 2019-12-19 15:25
 */
public class MyExecutor {

    /*
    动态代理的异步执行方法，参数就是 invoke(Object proxy, Method method, Object[] args)
     */
    public static void submit(Object object, Method method, Object[] args) throws Exception {
        //封装成callable接口
        MyDyCallable myCallable = new MyDyCallable(object, method, args);
        FutureTask futureTask = new FutureTask(myCallable);
        //运行线程
        new Thread(futureTask).start();


    }

    /*
    cglib的异步执行方法intercept(Object object, Method method, Object[] args, MethodProxy proxy)
     */
    public static void submit(Object object, Method method, Object[] args, MethodProxy proxy) throws Exception {
        //封装成callable接口
        MyCglibCallable myCglibCallable = new MyCglibCallable(object, method, args, proxy);
        FutureTask futureTask = new FutureTask(myCglibCallable);
        //运行线程
        new Thread(futureTask).start();


    }

}



