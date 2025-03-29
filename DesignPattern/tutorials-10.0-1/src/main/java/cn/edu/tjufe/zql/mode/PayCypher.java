package cn.edu.tjufe.zql.mode;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class PayCypher implements IPayMode {
    protected Logger logger= LoggerFactory.getLogger(PayCypher.class);

    @Override
    public boolean security(String uId) {
        logger.info("密码支付，风险校验环境安全");
        return true;
    }
}
