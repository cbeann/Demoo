package com.imooc.demo.dyproxy;

import com.imooc.demo.myinterface.MyAsyncInterface;
import com.imooc.demo.executor.MyExecutor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author CBeann
 * @create 2019-12-19 14:46
 */
public class MyAsyncHandler implements InvocationHandler {

    //目标对象
    private Object target;

    //传入代码目标对象
    public MyAsyncHandler(Object object) {
        this.target = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable, Exception {

        //method参数是接口的方法，上面是不带@MyAsyncInterface的，我们一般是定义在接口实现类上，所以我们通过接口的method获取target(实现类)的方法，从而获取自定义注解信息
        MyAsyncInterface annotation = target.getClass().getMethod(method.getName(), method.getParameterTypes()).getAnnotation(MyAsyncInterface.class);


        if (null != annotation) {
            //如果该方法有自定义异步注解，启动线程跑
            MyExecutor.submit(target, method, args);
        } else {
            //如果该方法没有自定义异步注解，同步执行
            Object invoke = method.invoke(target, args);
        }


        //如果有结果返回，如果没有就不返回
        return null;
    }
}
