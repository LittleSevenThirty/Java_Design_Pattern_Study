package cn.edu.tjufe.zql;

import com.alibaba.fastjson.JSON;
import junit.framework.TestCase;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class ActivityExecStatusControllerTest extends TestCase {
    private Logger logger = LoggerFactory.getLogger(ActivityExecStatusControllerTest.class);
    @Test
    public void test() {
        // 初始化数据
        String activityId = "100001";
        ActivityService.init(activityId, Status.EDITING);

        ActivityExecStatusController activityExecStatusController = new ActivityExecStatusController();
        Result resultRefuse = activityExecStatusController.execStatus(activityId, Status.EDITING, Status.REFUSE);
        logger.info("测试结果(编辑中To审核拒绝)：{}", JSON.toJSONString(resultRefuse));

        Result resultCheck = activityExecStatusController.execStatus(activityId, Status.EDITING, Status.CHECK);
        logger.info("测试结果(编辑中To提交审核)：{}", JSON.toJSONString(resultCheck));
    }
}