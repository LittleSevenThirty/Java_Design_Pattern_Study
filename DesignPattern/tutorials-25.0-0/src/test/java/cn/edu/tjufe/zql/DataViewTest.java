package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.vistor.impl.Parent;
import cn.edu.tjufe.zql.vistor.impl.Principal;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DataViewTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(DataViewTest.class);

    @Test
    public void test(){
        DataView dataView = new DataView();

        logger.info("\r\n家长视角访问：");
        dataView.show(new Parent());     // 家长

        logger.info("\r\n校长视角访问：");
        dataView.show(new Principal());  // 校长
    }
}