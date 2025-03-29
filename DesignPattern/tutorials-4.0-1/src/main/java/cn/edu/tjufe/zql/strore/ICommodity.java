package cn.edu.tjufe.zql.strore;

import java.util.Map;

/**
 * 记忆力：
 * commodity：奖品
 */
public interface ICommodity {
    // 发放奖品接口
    void sendCommodity(String uId, String commodityId,String bizId, Map<String,String> extMap)throws Exception;
}
