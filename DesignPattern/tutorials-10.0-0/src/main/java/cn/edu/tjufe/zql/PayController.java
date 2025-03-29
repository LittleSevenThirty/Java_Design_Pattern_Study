package cn.edu.tjufe.zql;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public class PayController {
    private Logger logger = LoggerFactory.getLogger(PayController.class);

    /**
     * 支付模式
     * @param uId   用户ID
     * @param tradeId   交易ID
     * @param amount    交易金额
     * @param channelType   支付渠道类型
     * @param modeType      支付模式类型
     * @return  支付成功否
     */
    public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modeType){
        if(1==channelType){
            logger.info("模拟微信渠道支付划账开始，uId：{}，tradeId：{}，amount：{}",uId,tradeId,amount);
            if (1 == modeType) {
                logger.info("密码支付，风控校验环境安全");
            } else if (2 == modeType) {
                logger.info("人脸支付，风控校验脸部识别");
            } else if (3 == modeType) {
                logger.info("指纹支付，风控校验指纹信息");
            }
        }
        else if(2==channelType){
            logger.info("模拟支付宝渠道支付划账开始，uId：{}，tradeId：{}，amount：{}",uId,tradeId,amount);
            if (1 == modeType) {
                logger.info("密码支付，风控校验环境安全");
            } else if (2 == modeType) {
                logger.info("人脸支付，风控校验脸部识别");
            } else if (3 == modeType) {
                logger.info("指纹支付，风控校验指纹信息");
            }
        }
        return true;
    }
}
