package cn.edu.tjufe.zql;


import java.util.Date;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/25
 * @github https://github.com/little-seven-thirty
 */
public class ActivityInfo {
    // 活动id
    private String activityId;
    // 活动名称
    private String activityName;
    // 活动状态
    private Enum<Status> status;
    // 开始时间
    private Date beginTime;
    // 结束时间
    private Date endTime;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Enum<Status> getStatus() {
        return status;
    }

    public void setStatus(Enum<Status> status) {
        this.status = status;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
