package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.card.IQiYiCardService;
import cn.edu.tjufe.zql.goods.DeliverReq;
import cn.edu.tjufe.zql.goods.GoodsService;
import cn.edu.tjufe.zql.service.CouponResult;
import cn.edu.tjufe.zql.service.CouponService;
import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PrizeController {
    private Logger logger = LoggerFactory.getLogger(PrizeController.class);

    public AwardRes awardToUser(AwardReq req) {
        String reqJson = JSON.toJSONString(req);
        AwardRes awardRes = null;
        try{
            logger.info("奖品发放开始{}。req:{}",req.getuId(),reqJson);
            // 按照不同类型方法商品【1.优惠卷、2.实物商品、3.第三方兑换卡（爱奇艺VIP）】
            if(req.getAwardType()==1){
                CouponService couponService = new CouponService();
                CouponResult couponResult = couponService.sendCoupon(req.getuId(),req.getAwardNumber(),req.getBizId());
                if("0000".equals(couponResult.getCode())){
                    awardRes = new AwardRes("0000","发放成功");
                }else{
                    awardRes = new AwardRes("0001",couponResult.getInfo());
                }
            }else if(req.getAwardType()==2){
                GoodsService goodsService = new GoodsService();
                DeliverReq deliverReq = new DeliverReq();
                deliverReq.setUserName(queryUserName(req.getuId()));
                deliverReq.setUserPhone(queryUserPhoneNumber(req.getuId()));
                deliverReq.setSku(req.getAwardNumber());
                deliverReq.setOrderId(req.getBizId());
                deliverReq.setConsigneeUserName(req.getExtMap().get("consigneeUserName"));
                deliverReq.setConsigneeUserPhone(req.getExtMap().get("consigneeUserPhone"));
                deliverReq.setConsigneeUserAddress(req.getExtMap().get("consigneeUserAddress"));
                Boolean isSuccess=goodsService.deliverGoods(deliverReq);
                if(isSuccess){
                    awardRes = new AwardRes("0000","发放成功");
                }else{
                    awardRes = new AwardRes("0001","发放失败");
                }
            }else if(req.getAwardType()==3){
                IQiYiCardService iQiYiCardService = new IQiYiCardService();
                iQiYiCardService.grantToken("123", req.getAwardNumber());
                awardRes = new AwardRes("0000", "发放成功");
            }
            logger.info("奖品发放完成{}。", req.getuId());
        }catch(Exception e){
            String bindMobileNumber = queryUserPhoneNumber(req.getuId());
            IQiYiCardService iQiYiCardService = new IQiYiCardService();
            iQiYiCardService.grantToken(bindMobileNumber, req.getAwardNumber());
            awardRes = new AwardRes("0000", "发放成功");
        }

        return awardRes;
    }

    private String queryUserName(String uId) {
        return "花花";
    }

    private String queryUserPhoneNumber(String uId) {
        return "15200101232";
    }
}
