package cn.edu.tjufe.zql.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 查询用户是否首单接口
 */
public class POPOrderService {
    private Logger logger = LoggerFactory.getLogger(POPOrderService.class);

    public boolean isFirstOrder(String userId){
        logger.info("POP商家，查询用户的订单是否为首单：{}",userId);
        return true;
    }
}
