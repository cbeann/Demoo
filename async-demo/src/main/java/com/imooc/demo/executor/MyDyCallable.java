package com.imooc.demo.executor;

import java.lang.reflect.Method;
import java.util.concurrent.Callable;

/**
 * @author CBeann
 * @create 2019-12-19 16:09
 */
public class MyDyCallable implements Callable<Object> {

    private Object target;
    private Method method;
    private Object[] args;

    public MyDyCallable(Object object, Method method, Object[] args) {
        this.target = object;
        this.method = method;
        this.args = args;

    }

    @Override
    public Object call() throws Exception {
        Object result = method.invoke(target, args);
        return result;
    }
}