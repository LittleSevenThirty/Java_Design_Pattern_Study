package cn.edu.tjufe.zql;

import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EngineControllerTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(EngineControllerTest.class);

    @Test
    public void test_engineContrller(){
        EngineController controller = new EngineController();
        String result=controller.process("Oli09pLkdjh","man",29);
        logger.info("测试结果：{}",result);
    }
}