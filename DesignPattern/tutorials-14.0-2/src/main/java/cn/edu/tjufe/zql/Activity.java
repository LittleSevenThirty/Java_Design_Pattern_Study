package cn.edu.tjufe.zql;

import java.util.Date;

/**
 * 活动类
 */
public class Activity {
    private long id;        // 活动id
    private String name;    // 活动名称
    private String desc;    // 活动描述
    private Date startTime; // 活动开始时间
    private Date endTime;   // 活动结束时间
    private Stock stock;    // 活动商品存货

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
