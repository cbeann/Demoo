package com.imooc.demo.executor;

import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author CBeann
 * @create 2019-12-19 16:45
 */
public class MyCglibCallable implements Callable {

    private Object object;
    private Method method;
    private Object[] args;
    private MethodProxy proxy;


    //参数是intercept(Object object, Method method, Object[] args, MethodProxy proxy)
    public MyCglibCallable(Object object, Method method, Object[] args, MethodProxy proxy) {
        this.object = object;
        this.args = args;
        this.method = method;
        this.proxy = proxy;

    }


    @Override
    public Object call() {
        try {
            proxy.invokeSuper(object, args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
