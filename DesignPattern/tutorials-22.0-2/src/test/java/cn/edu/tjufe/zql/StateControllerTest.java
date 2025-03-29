package cn.edu.tjufe.zql;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StateControllerTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test(){
        String activitiId = "100001";
        ActivityService.init(activitiId,Status.EDITING);
        StateController stateController = new StateController();
        Result result = stateController.arraignment(activitiId,Status.EDITING);
        logger.info("测试结果（编辑中To提审活动）：{}", JSON.toJSONString(result));
        logger.info("活动信息：{} 状态：{}",JSON.toJSONString(ActivityService.queryActivityInfo(activitiId)),JSON.toJSONString(ActivityService.queryActivityInfo(activitiId).getStatus()));
    }
}