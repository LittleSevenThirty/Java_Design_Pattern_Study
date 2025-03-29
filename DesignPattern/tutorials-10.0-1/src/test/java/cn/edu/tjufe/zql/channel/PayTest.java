package cn.edu.tjufe.zql.channel;

import cn.edu.tjufe.zql.mode.PayFaceMode;
import cn.edu.tjufe.zql.mode.PayFingerprintMode;
import junit.framework.TestCase;
import org.junit.Test;

import java.math.BigDecimal;

public class PayTest extends TestCase {
    @Test
    public void test_pay(){
        System.out.println("\r\n 模拟测试场景：微信支付，人脸支付");
        Pay wxPay = new WXPay(new PayFaceMode());
        wxPay.transfer("wiexin_1092033111","100000109893",new BigDecimal(100));

        System.out.println("\r\n 模拟测试场景：支付宝支付，指纹支付");
        Pay zfbPay = new ZFBPay(new PayFingerprintMode());
        zfbPay.transfer("zhifubao_1092033111","100000109894",new BigDecimal(220));
    }
}