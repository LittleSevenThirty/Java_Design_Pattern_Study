package cn.edu.tjufe.zql.impl;


import cn.edu.tjufe.zql.ICouponDiscount;

import java.math.BigDecimal;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/26
 * @github https://github.com/little-seven-thirty
 */
public class ZJCouponDiscount implements ICouponDiscount<Double> {
    /**
     * 直减计算
     * 1.使用商品价格减去优惠
     * 2.最低支付金额1元
     * @param couponInfo 折扣券信息；直减，满减，折扣，N元购
     * @param skuPrice 金额
     * @return
     */
    @Override
    public BigDecimal discountAmount(Double couponInfo, BigDecimal skuPrice) {
        BigDecimal discountAmount = skuPrice.subtract(new BigDecimal(couponInfo));
        if(discountAmount.compareTo(BigDecimal.ZERO) <1){return BigDecimal.ONE;}
        return discountAmount;
    }
}
