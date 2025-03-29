package cn.edu.tjufe.zql;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/24
 * @github https://github.com/little-seven-thirty
 */
public interface LotteryService {
    /**
     * 执行抽奖
     * @param uId   用户Id
     * @return  抽奖结果类
     */
    LotteryResult doDraw(String uId);
}
