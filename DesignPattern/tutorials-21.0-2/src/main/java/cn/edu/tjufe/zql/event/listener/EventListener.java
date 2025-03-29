package cn.edu.tjufe.zql.event.listener;

import cn.edu.tjufe.zql.LotteryResult;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/24
 * @github https://github.com/little-seven-thirty
 */
public interface EventListener {
    void doEvent(LotteryResult lotteryResult);
}
