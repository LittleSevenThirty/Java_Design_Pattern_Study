package cn.edu.tjufe.zql.cuisine.impl;


import cn.edu.tjufe.zql.cook.ICook;
import cn.edu.tjufe.zql.cuisine.ICuisine;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/23
 * @github https://github.com/little-seven-thirty
 */
public class SiChuanCuisine implements ICuisine {
    private ICook iCook;    // 每个菜系可以选择的厨师，不一定非要本地的来做

    public SiChuanCuisine(ICook iCook){
        this.iCook = iCook;
    }

    @Override
    public void cook() {
        this.iCook.doCooking();
    }
}
