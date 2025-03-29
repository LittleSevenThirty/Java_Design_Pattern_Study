package cn.edu.tjufe.zql;

public abstract class SsoDecorator implements HandlerInterceptor {
    private HandlerInterceptor handlerInterceptor;

    private SsoDecorator(){}

    public SsoDecorator(HandlerInterceptor handlerInterceptor){
        this.handlerInterceptor = handlerInterceptor;
    }

    @Override
    public boolean preHandle(String request,String response,Object handler){
        return this.handlerInterceptor.preHandle(request, response, handler);
    }
}
