package cn.edu.tjufe.zql;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 消息队列适配器
 */
public class MQAdapter {
    /**
     * 过滤器
     * @param strJson   被适配消息
     * @param link      通用返回信息成员属性 与 被适配消息成员属性的映射
     * @return
     * @throws Exception
     */
    public static RebateInfo filter(String strJson, Map<String,String> link)throws NoSuchMethodException, IllegalAccessException, InvocationTargetException{
        return filter(JSON.parseObject(strJson,Map.class),link);
    }

    public static RebateInfo filter(Map obj,Map<String,String> link)throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        RebateInfo rebateInfo = new RebateInfo();
        for(String key:link.keySet()){
            Object val = obj.get(link.get(key));
            RebateInfo.class.getMethod("set"+key.substring(0,1).toUpperCase()+key.substring(1),String.class)
                    .invoke(rebateInfo,val.toString());
        }
        return rebateInfo;
    }
}
