package cn.edu.tjufe.zql;


import cn.edu.tjufe.zql.cuisine.ICuisine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/23
 * @github https://github.com/little-seven-thirty
 */
public class XiaoEr {
    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);

    // 原来的Map结构改为list结构
    private List<ICuisine> cuisinelist = new ArrayList<ICuisine>();

    public void putCuisine(ICuisine cuisine) {
        cuisinelist.add(cuisine);
    }

    public void placeOrder(){
        for(ICuisine cuisine : cuisinelist){
            cuisine.cook();
        }
        cuisinelist.clear();
    }
}
