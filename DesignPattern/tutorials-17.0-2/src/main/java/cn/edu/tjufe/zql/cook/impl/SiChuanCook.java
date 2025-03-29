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
public class SiChuanCook implements ICook {
    private Logger logger= LoggerFactory.getLogger(SiChuanCook.class);

    @Override
    public void doCooking() {
        logger.info("四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系。");
    }
}
