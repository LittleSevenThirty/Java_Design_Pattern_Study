package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.mq.OrderMq;
import cn.edu.tjufe.zql.mq.create_account;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;

public class MQAdapterTest {
    @Test
    public void test_MQAdapter()throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        create_account createAccount = new create_account();
        createAccount.setNumber("100001");
        createAccount.setAddress("天津市.河西区.天津财经大学");
        createAccount.setAccountDate(new Date());
        createAccount.setDesc("在校开户");

        HashMap<String,String> link01 = new HashMap<>();
        link01.put("userId","number");
        link01.put("bizId","number");
        link01.put("bizTime","accountDate");
        link01.put("desc","desc");
        RebateInfo rebateInfo = MQAdapter.filter(createAccount.toString(),link01);
        System.out.println("mq.create_account(适配前)："+createAccount.toString());
        System.out.println("mq.create_account(适配后)："+ JSON.toJSONString(rebateInfo));

        System.out.println("");

        OrderMq orderMq = new OrderMq();
        orderMq.setUid("100001");
        orderMq.setSku("10928092093111123");
        orderMq.setOrderId("100000890193847111");
        orderMq.setCreateOrderTime(new Date());

        HashMap<String, String> link02 = new HashMap<String, String>();
        link02.put("userId", "uid");
        link02.put("bizId", "orderId");
        link02.put("bizTime", "createOrderTime");
        RebateInfo rebateInfo02 = MQAdapter.filter(orderMq.toString(), link02);

        System.out.println("mq.orderMq(适配前)" + orderMq.toString());
        System.out.println("mq.orderMq(适配后)" + JSON.toJSONString(rebateInfo02));
    }
}