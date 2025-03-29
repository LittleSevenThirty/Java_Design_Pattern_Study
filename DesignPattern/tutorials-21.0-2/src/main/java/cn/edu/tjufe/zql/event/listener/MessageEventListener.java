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
public class MessageEventListener implements EventListener {
    private Logger logger = LoggerFactory.getLogger(MessageEventListener.class);

    @Override
    public void doEvent(LotteryResult lotteryResult) {
        logger.info("给用户：{}，发送短信通知：{}",lotteryResult.getuId(),lotteryResult.getMsg());
    }
}
