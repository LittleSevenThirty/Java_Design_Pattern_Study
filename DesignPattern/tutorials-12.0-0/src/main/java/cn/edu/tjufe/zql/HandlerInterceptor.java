package cn.edu.tjufe.zql;

public interface HandlerInterceptor {
    boolean preHandle(String request,String response,Object handler);
}
