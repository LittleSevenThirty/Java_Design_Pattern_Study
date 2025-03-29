package cn.edu.tjufe.zql.event.listener;


import cn.edu.tjufe.zql.LotteryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/24
 * @github https://github.com/little-seven-thirty
 */
public class MQEventListener implements EventListener {
    private Logger logger = LoggerFactory.getLogger(MQEventListener.class);

    @Override
    public void doEvent(LotteryResult lotteryResult) {
        logger.info("记录用户：{}，摇号结果：{}",lotteryResult.getuId(),lotteryResult.getMsg());
    }
}
