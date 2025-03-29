package cn.edu.tjufe.zql;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 审核责任链
 * @authro 钟奇林
 * @description 这部分是责任链，链接起来的核心部分。AuthLink next，重点在于可以通过next方式获取下一个链路需要处理的节点。
 * @date 2025/3/22
 * @github https://github.com/little-seven-thirty
 */
public abstract class AuthLink {
    protected Logger logger = LoggerFactory.getLogger(AuthLink.class);

    protected DateFormat fatherDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 时间格式化
    protected String levelUserId;       // 级别人员ID
    protected String levelUserName;     // 级别人员姓名
    private AuthLink next;      // 责任链

    public AuthLink(String levelUserId, String levelUserName) {
        this.levelUserId = levelUserId;
        this.levelUserName = levelUserName;
    }

    public AuthLink getNext(){
        return next;
    }

    public  AuthLink appendNext(AuthLink next){
        this.next = next;
        return this;
    }

    public abstract AuthInfo doAuth(String uId, String orderId, Date authDate);
}
