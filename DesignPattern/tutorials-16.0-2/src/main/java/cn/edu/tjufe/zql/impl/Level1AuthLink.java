package cn.edu.tjufe.zql.impl;
import cn.edu.tjufe.zql.AuthInfo;
import cn.edu.tjufe.zql.AuthLink;
import cn.edu.tjufe.zql.AuthService;

import java.util.Date;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/22
 * @github https://github.com/little-seven-thirty
 */
public class Level1AuthLink extends AuthLink {

    public Level1AuthLink(String levelUserId,String levelUserName){
        super(levelUserId,levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId,orderId);
        if(null == date){
            return new AuthInfo("0001","单号",orderId,"状态：待一级审批负责人",levelUserName);
        }
        AuthLink next = super.getNext();
        if(null == next){
            return new AuthInfo("0000","单号",orderId,"状态：一级审批完成负责人",
                    fatherDate.format(date),"审批人：",levelUserName);
        }
        return next.doAuth(uId,orderId,authDate);       // 递归进入下一级责任创建
    }
}
