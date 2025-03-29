package cn.edu.tjufe.zql;

import java.util.Map;

public class AwardReq {
    private String uId;    // 用户唯一ID
    private Integer awardType; // 奖品类型（可用枚举类型）1.优惠卷、2.实物商品、3.第三方兑物卡（爱奇艺会员）
    private String awardNumber;// 奖品编号；sku、souponNumber、carId
    private String bizId;// 业务ID，防重复
    private Map<String,String> extMap; // 扩展信息


    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public Integer getAwardType() {
        return awardType;
    }

    public void setAwardType(Integer awardType) {
        this.awardType = awardType;
    }

    public String getAwardNumber() {
        return awardNumber;
    }

    public void setAwardNumber(String awardNumber) {
        this.awardNumber = awardNumber;
    }

    public String getBizId() {
        return bizId;
    }

    public void setBizId(String bizId) {
        this.bizId = bizId;
    }

    public Map<String, String> getExtMap() {
        return extMap;
    }

    public void setExtMap(Map<String, String> extMap) {
        this.extMap = extMap;
    }
}
