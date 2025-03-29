package cn.edu.tjufe.zql;


import cn.edu.tjufe.zql.domain.UserInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path="/api")
public class HelloWorldController {
    @Value("${server.port}")
    private int port;

    @RequestMapping(path = "/queryUserInfo",method= RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId){
        // 对比tutorials13.0-0// 一般额外代码添加如下
        // 做白名单，拦截
        List<String> userList = new ArrayList<>();
        userList.add("1001");
        userList.add("aaaa");
        userList.add("ccc");
        if(!userList.contains(userId)){
            return new UserInfo("1111","非白名单用户拦截！");
        }

        return new UserInfo("虫虫"+userId,19,"天津市南开区");
    }
}
