package cn.edu.tjufe.zql.impl;

import cn.edu.tjufe.zql.HttpClient;
import cn.edu.tjufe.zql.NetMall;
import com.alibaba.fastjson.JSON;
import java.util.Base64;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DangDangNetMall extends NetMall {

    public DangDangNetMall(String uId, String uPwd) {
        super(uId, uPwd);
    }

    @Override
    public Boolean login(String uId, String uPwd) {
        logger.info("模拟当当用户登录 uId：{} uPwd：{}", uId, uPwd);
        return true;
    }

    @Override
    public Map<String, String> reptile(String skuUrl) {
        String str = HttpClient.doGet(skuUrl);
        Pattern p9 = Pattern.compile("(?<=title\\>).*(?=</title)");
        Matcher m9 = p9.matcher(str);
        Map<String, String> map = new ConcurrentHashMap<String, String>();
        if (m9.find()) {
            map.put("name", m9.group());
        }
        map.put("price", "4548.00");
        logger.info("模拟当当商品爬虫解析：{} | {} 元 {}", map.get("name"), map.get("price"), skuUrl);
        return map;
    }

    @Override
    public String createBase64(Map<String, String> goodsInfo) {
        Base64.Encoder encoder = Base64.getEncoder();
        logger.info("模拟生成当当商品base64海报");
        return encoder.encode(JSON.toJSONString(goodsInfo).getBytes()).toString();
    }

}
