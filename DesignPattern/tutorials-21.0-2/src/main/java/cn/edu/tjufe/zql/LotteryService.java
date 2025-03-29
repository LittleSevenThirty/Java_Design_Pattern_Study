package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.event.EventManager;
import cn.edu.tjufe.zql.event.listener.MQEventListener;
import cn.edu.tjufe.zql.event.listener.MessageEventListener;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/24
 * @github https://github.com/little-seven-thirty
 */
public abstract class LotteryService {
    private EventManager eventManager;

    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MESSAGE,EventManager.EventType.MQ);
        eventManager.subscribe(EventManager.EventType.MQ,new MQEventListener());
        eventManager.subscribe(EventManager.EventType.MESSAGE,new MessageEventListener());
    }

    public LotteryResult draw(String uId){
        LotteryResult lotteryResult=doDraw(uId);
        // 需要调用什么监听就调用什么
        eventManager.notify(EventManager.EventType.MESSAGE,lotteryResult);
        eventManager.notify(EventManager.EventType.MQ,lotteryResult);
        return lotteryResult;
    }

    /**
     * 执行抽奖
     * @param uId   用户Id
     * @return  抽奖结果类
     */
    protected abstract LotteryResult doDraw(String uId);
}
