package cn.edu.tjufe.zql.mode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayFingerprintMode implements IPayMode {
    protected Logger logger = LoggerFactory.getLogger(PayFingerprintMode.class);

    public boolean security(String uId){
        logger.info("指纹支付，风险校验指纹信息");
        return true;
    }
}
