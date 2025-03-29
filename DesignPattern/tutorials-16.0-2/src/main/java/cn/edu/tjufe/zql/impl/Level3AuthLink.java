package cn.edu.tjufe.zql.impl;


import cn.edu.tjufe.zql.AuthInfo;
import cn.edu.tjufe.zql.AuthLink;
import cn.edu.tjufe.zql.AuthService;

import java.text.ParseException;
import java.util.Date;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/22
 * @github https://github.com/little-seven-thirty
 */
public class Level3AuthLink extends AuthLink {
    private Date beginDate = fatherDate.parse("2025-03-23 00:00:00");
    private Date endDate = fatherDate.parse("2025-03-24 00:00:00");

    public Level3AuthLink(String levelUserId,String levelUserName) throws ParseException {
        super(levelUserId,levelUserName);
    }

    @Override
    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId,orderId);
        if(null == date){
            return new AuthInfo("0001","单号：",orderId,"状态：待三级审批负责人",levelUserName);
        }
        AuthLink next = super.getNext();
        if(null == next){
            return new AuthInfo("0000","单号",orderId,"状态：三级审批完成负责人",
                    fatherDate.format(date),"审批人：",levelUserName);
        }

        if(authDate.before(beginDate)||authDate.after(endDate)){
            return new AuthInfo("0000","单号",orderId,"状态：三级审批完成负责人",
                    fatherDate.format(date),"审批人：",levelUserName);
        }
        return next.doAuth(uId,orderId,authDate);       // 递归进入下一级责任创建
    }
}
