package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.ceilling.LevelOneCeiling;
import cn.edu.tjufe.zql.ceilling.LevelTwoCeiling;
import cn.edu.tjufe.zql.coat.DuluxCoat;
import cn.edu.tjufe.zql.coat.LiBangCoat;
import cn.edu.tjufe.zql.floor.DerFloor;
import cn.edu.tjufe.zql.floor.ShengXiangFloor;
import cn.edu.tjufe.zql.tile.DongPengTile;
import cn.edu.tjufe.zql.tile.MarcoPoloTile;

/**
 * 建造器，在此定义自己的
 */
public class Builder {

    public IMenu levelOne(Double area) {
        return new DecorationPackageMenu(area, "豪华欧式")
                .appendCeiling(new LevelTwoCeiling())    // 吊顶，二级顶
                .appendCoat(new DuluxCoat())             // 涂料，多乐士
                .appendFloor(new ShengXiangFloor());     // 地板，圣象
    }

    public IMenu levelTwo(Double area) {
        return new DecorationPackageMenu(area, "轻奢田园")
                .appendCeiling(new LevelTwoCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new MarcoPoloTile());       // 地砖，马可波罗
    }

    public IMenu levelThree(Double area) {
        return new DecorationPackageMenu(area, "现代简约")
                .appendCeiling(new LevelOneCeiling())   // 吊顶，二级顶
                .appendCoat(new LiBangCoat())           // 涂料，立邦
                .appendTile(new DongPengTile());        // 地砖，东鹏
    }

    public IMenu levelMy(Double area) {
        return new DecorationPackageMenu(area, "我的风格")
                .appendCeiling(new LevelTwoCeiling())   // 选择二级吊顶
                .appendCoat(new LiBangCoat())           // 涂料 立邦
                .appendFloor(new DerFloor());           // 德尔 地板
    }
}
