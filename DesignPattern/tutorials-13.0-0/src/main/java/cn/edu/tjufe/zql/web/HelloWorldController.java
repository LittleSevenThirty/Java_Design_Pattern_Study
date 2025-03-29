package cn.edu.tjufe.zql.web;

import cn.edu.tjufe.zql.domain.UserInfo;
import cn.edu.tjufe.zql.door.annotation.DoDoor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/api")
public class HelloWorldController {
    @Value("${server.port}")
    private int port;

    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"非白名单可访问用户拦截！\"}")
    @RequestMapping(path = "/queryUserInfo",method= RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId){
        return new UserInfo("虫虫"+userId,19,"天津市南开区");
    }
}
