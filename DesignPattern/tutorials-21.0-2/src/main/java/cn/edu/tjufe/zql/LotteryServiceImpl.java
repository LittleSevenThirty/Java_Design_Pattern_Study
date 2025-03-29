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
public class LotteryServiceImpl extends LotteryService {
    private Logger logger = LoggerFactory.getLogger(LotteryServiceImpl.class);

    private MinibusTargetService minibusTargetService=new MinibusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {
        String lotteryMes=minibusTargetService.lottery(uId);
        return new LotteryResult(uId,lotteryMes,new Date());
    }
}
