package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.utils.RedisUtils;

public class ActivityController {
    private RedisUtils redisUtile = new RedisUtils();

    public Activity queryActivityInfo(long id){
        Activity activity = ActivityFactory.getActivity(id);
        Stock stock= new Stock(1000,redisUtile.getStockUsed());
        activity.setStock(stock);
        return activity;
    }
}
