package cn.edu.tjufe.zql.agent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import java.lang.reflect.Proxy;

import java.lang.reflect.InvocationHandler;

public class MapperFactoryBean<T> implements FactoryBean<T> {
    private Logger logger = LoggerFactory.getLogger(MapperFactoryBean.class);

    private Class<T> mapperInterface;

    public MapperFactoryBean(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    @Override
    public T getObject() throws Exception {
        InvocationHandler handler =(proxy,method,args)->{
            // method是 Method method = MyClass.class.getMethod("method方法名");
            Select select = method.getAnnotation(Select.class);
            logger.info("SQL:{}",select.value().replace("#{uId}",args[0].toString()));
            return args[0] + ",钟奇林,tjufe.cn - 沉淀，成长，收获";
        };
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{mapperInterface},handler);
    }

    @Override
    public Class<?> getObjectType() {
        return mapperInterface;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
