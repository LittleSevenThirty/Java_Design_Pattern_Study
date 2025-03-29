package cn.edu.tjufe.zql;

import java.math.BigDecimal;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/26
 * @github https://github.com/little-seven-thirty
 */
public interface ICouponDiscount<T> {
    /**
     * 优惠券金额计算
     * @param couponInfo 折扣券信息；直减，满减，折扣，N元购
     * @param skuPrice 金额
     * @return 优惠后金额
     */
    BigDecimal discountAmount(T couponInfo,BigDecimal skuPrice);
}
