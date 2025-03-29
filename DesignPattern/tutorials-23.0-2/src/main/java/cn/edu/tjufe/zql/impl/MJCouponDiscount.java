package cn.edu.tjufe.zql.impl;


import cn.edu.tjufe.zql.ICouponDiscount;

import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/26
 * @github https://github.com/little-seven-thirty
 */
public class MJCouponDiscount implements ICouponDiscount<Map<String,String>> {

    /**
     * 满减计算
     * 1. 判断满足x元后-n元，否则不减
     * 2. 最低1元
     * @param couponInfo 折扣券信息；直减，满减，折扣，N元购
     * @param skuPrice 金额
     * @return
     */
    @Override
    public BigDecimal discountAmount(Map<String, String> couponInfo, BigDecimal skuPrice) {
        String x = couponInfo.get("x");
        String n = couponInfo.get("n");

        if(skuPrice.compareTo(new BigDecimal(x))<0)return skuPrice;
        // 满足条件，减去金额
        BigDecimal discount=skuPrice.subtract(new BigDecimal(n));
        if(discount.compareTo(BigDecimal.ZERO)<1)return BigDecimal.ONE;
        return discount;
    }
}
