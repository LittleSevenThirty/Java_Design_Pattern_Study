package cn.edu.tjufe.zql;


import java.math.BigDecimal;

/**
 *
 * @authro 钟奇林
 * @description 优惠策略管理类
 * @date 2025/3/26
 * @github https://github.com/little-seven-thirty
 */
public class Manager<T> {
    private ICouponDiscount<T> iCouponDiscount;

    public Manager(ICouponDiscount<T> iCouponDiscount) {
        this.iCouponDiscount = iCouponDiscount;
    }

    // 一个统一的接口，综合所有策略
    public BigDecimal discountAmount(T couponInfo,BigDecimal skuPrice) {
        return iCouponDiscount.discountAmount(couponInfo, skuPrice);
    }
}
