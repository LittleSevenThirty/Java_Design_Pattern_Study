package cn.edu.tjufe.zql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginSsoDecorator extends SsoInterceptor{
    private Logger logger = LoggerFactory.getLogger(LoginSsoDecorator.class);
    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

    static {
        authMap.put("huahua","queryUserInfo");
        authMap.put("doudou","queryUserInfo");
    }

    @Override
    public boolean preHandle(String request,String response,Object handler){
        // 模拟获取cookie
        String cookie = request.substring(1,8);
        // 模拟校验
        boolean success=cookie.equals("success");

        if(!success)return false;

        // 模拟方法校验
        String userId = request.substring(9);
        String method = authMap.get(userId);

        return "queryUserInfo".equals(method);
    }
}
