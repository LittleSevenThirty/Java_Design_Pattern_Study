package cn.edu.tjufe.zql;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LotteryServiceImplTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test() {
        LotteryService lotteryService = new LotteryServiceImpl();
        LotteryResult result = lotteryService.doDraw("2765789109876");
        logger.info("测试结果：{}", JSON.toJSONString(result));
    }
}