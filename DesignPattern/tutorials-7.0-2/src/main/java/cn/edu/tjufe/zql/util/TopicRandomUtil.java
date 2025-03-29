package cn.edu.tjufe.zql.util;

import java.util.*;

public class TopicRandomUtil {
    /**
     *
     * @param options 题目选项
     * @param key      答案
     * @return          乱序后的题目选项和答案
     */
    static public Topic random(Map<String,String> options, String key){
        Set<String> keySet = options.keySet();
        ArrayList<String> keyList = new ArrayList<String>(keySet);
        Collections.shuffle(keyList);   // 打乱键序
        HashMap<String,String> newOptions = new HashMap<String,String>();
        int idx=0;
        String newKey = "";
        for(String next: keySet){
            String randomKey = keyList.get(idx++);
            if(key.equals(next)){
                newKey = randomKey;     // 重新记录答案位置
            }
            newOptions.put(randomKey,options.get(next));    // 插入乱序数据
        }
        return new Topic(newOptions,newKey);
    }
}
