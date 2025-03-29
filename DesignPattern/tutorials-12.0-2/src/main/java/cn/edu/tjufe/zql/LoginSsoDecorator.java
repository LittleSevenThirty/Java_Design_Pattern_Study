package cn.edu.tjufe.zql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class LoginSsoDecorator extends SsoDecorator{
    private Logger logger = LoggerFactory.getLogger(LoginSsoDecorator.class);
    private static Map<String, String> authMap = new ConcurrentHashMap<String, String>();

    static {
        authMap.put("huahua","queryUserInfo");
        authMap.put("doudou","queryUserInfo");
    }

    public LoginSsoDecorator(HandlerInterceptor handlerInterceptor) {
        super(handlerInterceptor);
    }

    @Override
    public boolean preHandle(String request,String response,Object handler){
        // 原版代码：这里可以使用装饰器来替代
//        // 模拟获取cookie
//        String cookie = request.substring(1,8);
//        // 模拟校验
//        boolean success=cookie.equals("success");
        boolean success = super.preHandle(request, response, handler);

        // 向下可以扩展的代码部分：
        if(!success)return false;

        // 模拟方法校验
        String userId = request.substring(8);
        String method = authMap.get(userId);
        logger.info("模拟单点登录方法访问拦截校验：{} {}", userId, method);
        return "queryUserInfo".equals(method);
    }
}
