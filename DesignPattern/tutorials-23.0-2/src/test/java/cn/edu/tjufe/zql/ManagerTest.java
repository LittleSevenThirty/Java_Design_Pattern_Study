package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.impl.MJCouponDiscount;
import cn.edu.tjufe.zql.impl.NYGCouponDiscount;
import cn.edu.tjufe.zql.impl.ZJCouponDiscount;
import cn.edu.tjufe.zql.impl.ZKCouponDiscount;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ManagerTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(ManagerTest.class);

    @Test
    public void test_zj(){
        Manager<Double> manager = new Manager<>(new ZJCouponDiscount());
        BigDecimal discountAmount = manager.discountAmount(10D, new BigDecimal(100));
        logger.info("测试结果：直减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_mj(){
        Manager<Map<String,String>> manager = new Manager<>(new MJCouponDiscount());
        Map<String,String> mapReq = new HashMap<String, String>();
        mapReq.put("x","100");
        mapReq.put("n","100");
        BigDecimal discountAmount = manager.discountAmount(mapReq, new BigDecimal(100));
        logger.info("测试结果：满减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_nyg(){
        Manager<Double> manager = new Manager<>(new NYGCouponDiscount());
        BigDecimal discountAmount = manager.discountAmount(90D, new BigDecimal(100));
        logger.info("测试结果：n元购优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_zk(){
        Manager<Double> manager = new Manager<>(new ZKCouponDiscount());
        BigDecimal discountAmount = manager.discountAmount(0.75D, new BigDecimal(100));
        logger.info("测试结果：折扣优惠后金额 {}", discountAmount);
    }
}