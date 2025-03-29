package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.mq.OrderMq;
import com.alibaba.fastjson.JSON;

/**
 * 订单消息队列服务
 */
public class OrderMqService {

    public void onMessage(String message) {

        OrderMq mq = JSON.parseObject(message, OrderMq.class);

        mq.getUid();
        mq.getOrderId();
        mq.getCreateOrderTime();

        // ... 处理自己的业务
    }
}
