package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.cook.impl.GuangDongCook;
import cn.edu.tjufe.zql.cook.impl.JiangSuCook;
import cn.edu.tjufe.zql.cook.impl.ShanDongCook;
import cn.edu.tjufe.zql.cook.impl.SiChuanCook;
import cn.edu.tjufe.zql.cuisine.impl.*;
import junit.framework.TestCase;
import org.junit.Test;

public class XiaoErTest extends TestCase {
    @Test
    public void test() {
        // 菜系 + 厨师；广东（粤菜）、江苏（苏菜）、山东（鲁菜）、四川（川菜）
        GuangDongCuisine guangDoneCuisine = new GuangDongCuisine(new GuangDongCook());
        JiangSuCuisine jiangSuCuisine = new JiangSuCuisine(new JiangSuCook());
        ShangDongCuisine shanDongCuisine = new ShangDongCuisine(new ShanDongCook());
        SiChuanCuisine siChuanCuisine = new SiChuanCuisine(new SiChuanCook());
        // 我想吃由四川厨师做的苏菜
        JiangSuCuisine jiangSuCuisine1 = new JiangSuCuisine(new SiChuanCook());

        // 点单
        XiaoEr xiaoEr = new XiaoEr();
        xiaoEr.putCuisine(guangDoneCuisine);
        xiaoEr.putCuisine(jiangSuCuisine);
        xiaoEr.putCuisine(shanDongCuisine);
        xiaoEr.putCuisine(siChuanCuisine);
        xiaoEr.putCuisine(jiangSuCuisine1);

        // 下单
        xiaoEr.placeOrder();
    }
}