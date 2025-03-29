package cn.edu.tjufe.zql;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/24
 * @github https://github.com/little-seven-thirty
 */
public class LotteryServiceImpl implements LotteryService {
    private Logger logger = LoggerFactory.getLogger(LotteryServiceImpl.class);

    private MinibusTargetService minibusTargetService=new MinibusTargetService();

    @Override
    public LotteryResult doDraw(String uId) {
        String lotteryMes=minibusTargetService.lottery(uId);
        // 发短信
        logger.info("用户：{}，发送短信通知：{}",uId,lotteryMes);
        // 发送MQ
        logger.info("用户：{}，摇号结果：{}",uId,lotteryMes);
        return new LotteryResult(uId,lotteryMes,new Date());
    }
}
