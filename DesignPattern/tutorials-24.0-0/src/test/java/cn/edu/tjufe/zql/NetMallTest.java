package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.impl.JDNetMall;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetMallTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(NetMallTest.class);

    @Test
    public void test_NetMall() {
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("测试结果：{}", base64);
    }
}