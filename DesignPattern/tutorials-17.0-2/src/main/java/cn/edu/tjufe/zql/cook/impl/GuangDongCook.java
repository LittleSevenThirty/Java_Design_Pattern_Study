package cn.edu.tjufe.zql.cook.impl;


import cn.edu.tjufe.zql.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/23
 * @github https://github.com/little-seven-thirty
 */
public class GuangDongCook implements ICook {
    private Logger logger= LoggerFactory.getLogger(GuangDongCook.class);

    @Override
    public void doCooking() {
        logger.info("广东厨师，烹饪鲁菜，宫廷最大菜系，以孔府风味为龙头");
    }
}
