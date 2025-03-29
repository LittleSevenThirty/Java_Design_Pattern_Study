package cn.edu.tjufe.zql;
import java.util.Date;

import java.util.HashMap;
import java.util.Map;

/**
 * 活动享元工厂
 */
public class ActivityFactory {
    static Map<Long, Activity> activityMap = new HashMap<Long,Activity>();

    public static Activity getActivity(long id){
        Activity activity = activityMap.get(id);
        if(null==activity){
            // 模拟从实际业务应用从接口中获取活动信息
            activity = new Activity();
            activity.setId(10001L);
            activity.setName("图书嗨乐");
            activity.setDesc("图书优惠券分享激励分享活动第二期");
            activity.setStartTime(new Date());
            activity.setEndTime(new Date());
            activityMap.put(id, activity);
        }
        return activity;
    }
}
