package cn.edu.tjufe.zql;

import junit.framework.TestCase;
import org.junit.Test;

public class LoginSsoDecoratorTest extends TestCase {
    @Test
    public void testLoginSsoDecorator() {
        LoginSsoDecorator loginDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = loginDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }
}