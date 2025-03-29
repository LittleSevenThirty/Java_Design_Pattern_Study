package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.mq.POPOrderDelivered;
import com.alibaba.fastjson.JSON;

public class POPOrderDeliveredService {

    public void onMessage(String message) {

        POPOrderDelivered mq = JSON.parseObject(message, POPOrderDelivered.class);

        mq.getuId();
        mq.getOrderId();
        mq.getOrderTime();

        // ... 处理自己的业务
    }
}
