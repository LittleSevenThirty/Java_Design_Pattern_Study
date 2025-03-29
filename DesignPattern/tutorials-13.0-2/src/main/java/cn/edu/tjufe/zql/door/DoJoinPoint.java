package cn.edu.tjufe.zql.door;

import cn.edu.tjufe.zql.door.annotation.DoDoor;
import cn.edu.tjufe.zql.door.config.StarterService;
import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * 定义白名单切面逻辑
 */
@Aspect
@Component  // 无明确角色的Spring Framework声明Bean注解
public class DoJoinPoint {
    private Logger logger = LoggerFactory.getLogger(DoJoinPoint.class);

    @Autowired
    private StarterService starterService;

    @Pointcut("@annotation(cn.edu.tjufe.zql.door.annotation.DoDoor)")
    public void aopPoint(){
    }

    @Around("aopPoint()")
    public Object doRouter(ProceedingJoinPoint jp) throws Throwable {
        //获取内容
        Method method = getMethod(jp);
        DoDoor door = method.getAnnotation(DoDoor.class);
        //获取字段值
        String keyValue = getFieldValue(door.key(), jp.getArgs());
        logger.info("itstack door handler method：{} value：{}", method.getName(), keyValue);
        if (null == keyValue || "".equals(keyValue)) return jp.proceed();
        //配置内容
        String[] split = starterService.split(",");
        //白名单过滤
        for (String str : split) {
            if (keyValue.equals(str)) {
                return jp.proceed();
            }
        }
        //拦截
        return returnObject(door, method);
    }

    private Method getMethod(JoinPoint jp) throws NoSuchMethodException {
        Signature sig = jp.getSignature();
        MethodSignature methodSignature = (MethodSignature) sig;
        return getClass(jp).getMethod(methodSignature.getName(), methodSignature.getParameterTypes());
    }

    private Class<? extends Object> getClass(JoinPoint jp) throws NoSuchMethodException {
        return jp.getTarget().getClass();
    }

    //返回对象
    private Object returnObject(DoDoor doGate, Method method) throws IllegalAccessException, InstantiationException {
        Class<?> returnType = method.getReturnType();
        String returnJson = doGate.returnJson();
        if ("".equals(returnJson)) {
            return returnType.newInstance();
        }
        return JSON.parseObject(returnJson, returnType);
    }

    // 注意：修正方法名拼写错误 filed -> field
    private String getFieldValue(String field, Object[] args) {
        String fieldValue = null;
        for (Object arg : args) {
            try {
                if (fieldValue != null && !fieldValue.isEmpty()) {
                    break; // 已找到值，跳出循环
                }

                // 1. 处理 Map 类型参数
                if (arg instanceof Map) {
                    Object value = ((Map<?, ?>) arg).get(field);
                    if (value != null) {
                        fieldValue = value.toString();
                    }
                    continue; // 处理完 Map，进入下一个参数
                }

                // 2. 处理普通对象，使用反射获取字段值
                Class<?> clazz = arg.getClass();
                Field declaredField;
                try {
                    declaredField = clazz.getDeclaredField(field); // 查找字段（包括私有）
                } catch (NoSuchFieldException e) {
                    continue; // 字段不存在，跳过该参数
                }

                declaredField.setAccessible(true); // 允许访问私有字段
                Object value = declaredField.get(arg);
                if (value != null) {
                    fieldValue = value.toString();
                }

            } catch (Exception e) {
                // 异常处理：如果参数只有一个，返回其字符串形式
                if (args.length == 1) {
                    return args.toString();
                }
            }
        }
        return fieldValue;
    }

}
