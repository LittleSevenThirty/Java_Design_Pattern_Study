package cn.edu.tjufe.zql.factory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JDKInvocationHandler implements InvocationHandler {
    private ICacheAdapter cacheAdapter;

    public JDKInvocationHandler(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return ICacheAdapter.class.getMethod(method.getName(), getParameterTypes(args));
    }

    private Class<?>[] getParameterTypes(Object[] args) {
        if (args == null) return new Class<?>[0];
        Class<?>[] paramTypes = new Class<?>[args.length];
        for (int i = 0; i < args.length; i++) {
            paramTypes[i] = (args[i] != null) ? args[i].getClass() : Object.class; // null 时默认 Object
        }
        return paramTypes;
    }
}

//ICacheAdapter.class.getMethod(...)
//
//通过反射从 ICacheAdapter 接口中找到与调用方法同名且参数类型匹配的方法。
//        method.getName()：获取被调用方法的名字（例如 "save"）。
//        ClassLoaderUtils.getClazzByArgs(args)：将参数列表 args 转换为对应的 Class<?>[] 类型数组（例如 [String.class, String.class]）
//        .invoke(cacheAdapter, args)
//
//通过反射实际调用 cacheAdapter 对象中的对应方法。
//cacheAdapter 是 ICacheAdapter 接口的具体实现类实例。
//args 是原始方法调用的参数。
//返回值
//‌返回类型‌：Object
//‌含义‌：返回被调用方法的具体结果。例如，如果调用的是 cache.get("key")，返回值可能是 "value"。