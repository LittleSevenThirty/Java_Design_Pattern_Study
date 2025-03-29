package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.mq.create_account;
import com.alibaba.fastjson.JSON;

public class create_accountMqService {
    public void onMessage(String message) {
        // JSON.parseObject用于将某一字符串解析为要求类的格式
        create_account mq = JSON.parseObject(message, create_account.class);

        mq.getNumber();
        mq.getAccountDate();

        // ...处理自己的业务
    }
}
