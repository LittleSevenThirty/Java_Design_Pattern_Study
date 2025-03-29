package cn.edu.tjufe.zql.channel;

import cn.edu.tjufe.zql.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

public abstract class Pay {
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    public IPayMode payMode ;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    /**
     * 模拟交易
     * @param uId   用户ID
     * @param tradeId   交易ID
     * @param amount    交易金额
     * @return
     */
    public abstract String transfer(String uId, String tradeId, BigDecimal amount);
}
