package cn.edu.tjufe.zql;


/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/26
 * @github https://github.com/little-seven-thirty
 */
public class CouponDiscountService {
    public double discountAmount(int type,double typeContent,double skuPrice,double typeExt){
        // 直减券
        if(1==type){
            return skuPrice-typeContent;
        }
        // 满减券
        if(2==type){
            if(skuPrice<typeExt)return skuPrice;
            return skuPrice-typeContent;
        }
        // 折扣券
        if(3==type){
            return skuPrice*typeContent;
        }
        // N元购
        if(4==type){
            return typeContent;
        }
        return 0D;
    }
}
