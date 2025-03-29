package cn.edu.tjufe.zql;
import java.util.Date;
import cn.edu.tjufe.zql.Stock;

public class ActivityController {
    public Activity queryActivityInfo(Long id){
        // 模拟从实际业应用接口中获取活动信息
        Activity activity = new Activity();
        activity.setId(10001L);
        activity.setName("图书嗨了");
        activity.setDesc("图书优惠券分享激励活动第二期");
        activity.setStartTime(new Date());
        activity.setEndTime(new Date());
        activity.setStock(new Stock(1000,1));

        return null;
    }
}
