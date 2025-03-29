package cn.edu.tjufe.zql;

public class SsoInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(String request,String response,Object handler){
        // 模拟获取cookie
        String cookie = request.substring(1,8);
        // 模拟校验
        return "success".equals(cookie);
    }
}
