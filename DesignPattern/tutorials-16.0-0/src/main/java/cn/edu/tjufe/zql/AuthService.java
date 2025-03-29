package cn.edu.tjufe.zql;


import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
*
* @authro 钟奇林
* @description 
* @date 2025/3/22
* @github https://github.com/little-seven-thirty
*/
public class AuthService {

    private static Map<String, Date> authMap = new ConcurrentHashMap<String, Date>();

    // 获取审核信息创建时间
    public static Date queryAuthInfo(String uId, String orderId) {
        return authMap.get(uId.concat(orderId));
    }

    public static void putAuth(String uId, String orderId) {
        authMap.put(uId.concat(orderId), new Date());
    }

}
