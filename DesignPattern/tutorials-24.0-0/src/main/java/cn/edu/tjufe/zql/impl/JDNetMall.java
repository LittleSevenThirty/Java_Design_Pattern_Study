package cn.edu.tjufe.zql.impl;


import cn.edu.tjufe.zql.HttpClient;
import cn.edu.tjufe.zql.NetMall;
import java.util.Base64;
import com.alibaba.fastjson.JSON;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @authro 钟奇林
 * @description 模拟爬虫京东
 * @date 2025/3/26
 * @github https://github.com/little-seven-thirty
 */
public class JDNetMall extends NetMall {

    public JDNetMall(String uId,String uPwd) {
        super(uId,uPwd);
    }

    @Override
    protected Boolean login(String uId, String uPwd) {
        logger.info("模拟京东用户登录：uId：{} uPwd：{}",uId,uPwd);
        return true;
    }

    @Override
    protected Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9= Pattern.compile("(?<=title\\>).*(?=</title)");      // 创建匹配的正则字符串
        Matcher m9= p9.matcher(str);    // 匹配
        Map<String,String> map = new ConcurrentHashMap<String,String>();
        if(m9.find()){
            map.put("name",m9.group());
        }
        map.put("price","5999.00");
        logger.info("模拟京东商品爬虫解析：{} | {}元 {}",map.get("name"),map.get("price"),skuUrl);
        return map;
    }

    @Override
    protected String createBase64(Map<String, String> goodsInfo) {
        Base64.Encoder encoder = Base64.getEncoder();
        logger.info("模拟生成京东商品base64海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes()).toString();
    }
}
