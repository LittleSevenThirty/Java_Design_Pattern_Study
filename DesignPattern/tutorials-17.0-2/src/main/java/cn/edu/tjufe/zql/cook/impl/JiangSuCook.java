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
public class JiangSuCook implements ICook {
    private Logger logger= LoggerFactory.getLogger(JiangSuCook.class);

    @Override
    public void doCooking() {
        logger.info("江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系。");
    }
}
