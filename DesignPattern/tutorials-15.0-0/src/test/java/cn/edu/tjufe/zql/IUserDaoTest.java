package cn.edu.tjufe.zql;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class IUserDaoTest extends TestCase {

    private Logger logger = LoggerFactory.getLogger(IUserDaoTest.class);

    @Test
    public void test_IUserDao() throws BeansException {
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserDao userDao = beanFactory.getBean("userDao", IUserDao.class);
        String res = userDao.queryUserInfo("100001");
        logger.info("测试结果：{}", res);
    }
}