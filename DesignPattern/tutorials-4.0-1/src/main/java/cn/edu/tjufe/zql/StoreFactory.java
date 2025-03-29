package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.strore.ICommodity;
import cn.edu.tjufe.zql.strore.impl.CardCommodityService;
import cn.edu.tjufe.zql.strore.impl.CouponCommondityService;
import cn.edu.tjufe.zql.strore.impl.GoodsCommodityService;


public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType){
        // 判空
        if(commodityType==null)return null;
        if(commodityType==1)return new CouponCommondityService();
        if(commodityType==2)return new GoodsCommodityService();
        if(commodityType==3)return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
