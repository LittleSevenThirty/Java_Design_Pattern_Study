package cn.edu.tjufe.zql.strore.impl;

import cn.edu.tjufe.zql.strore.ICommodity;
import cn.edu.tjufe.zql.strore.coupon.CouponResult;
import cn.edu.tjufe.zql.strore.coupon.CouponService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class CouponCommondityService implements ICommodity {
    private Logger logger = LoggerFactory.getLogger(CouponCommondityService.class);

    private CouponService couponService=new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId,String bizId, Map<String,String> extMap)throws Exception{
        CouponResult couponResult=couponService.sendCoupon(uId,commodityId,bizId);
        logger.info("请求参数【优惠券】=>uId：{} commodityId：{} bizId：{} extMap：{}",uId,commodityId,bizId,extMap);
        logger.info("测试结果【优惠券】：{}", JSON.toJSONString(couponResult));
        if(!"0000".equals(couponResult.getCode()))throw new RuntimeException(couponResult.getInfo());
    }
}
