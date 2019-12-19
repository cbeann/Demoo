package com.imooc.demo.cglibproxy;

import com.imooc.demo.executor.MyExecutor;
import com.imooc.demo.myinterface.MyAsyncInterface;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author CBeann
 * @create 2019-12-19 16:32
 */
public class CGlibProxy implements MethodInterceptor {


    private Enhancer enhancer = new Enhancer();


    public Object getProxy(Class clz) {
        enhancer.setSuperclass(clz);
        enhancer.setCallback(this);
        return enhancer.create();

    }

    /**
     * @param object 目标类的实例
     * @param method 目标方法的反射对象
     * @param args   目标方法的参数
     * @param proxy  代理类的实例
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object object, Method method, Object[] args, MethodProxy proxy) throws Throwable {


        if (method.getAnnotation(MyAsyncInterface.class) != null) {
            MyExecutor.submit(object, method, args, proxy);
        } else {
            proxy.invokeSuper(object, args);
        }


        return null;
    }
}
