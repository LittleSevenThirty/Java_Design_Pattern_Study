package cn.edu.tjufe.zql.impl;

import cn.edu.tjufe.zql.ActivityService;
import cn.edu.tjufe.zql.Result;
import cn.edu.tjufe.zql.State;
import cn.edu.tjufe.zql.Status;

/**
 * 活动状态；活动关闭
 */
public class CloseState extends State {

    public Result arraignment(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可提审");
    }

    public Result checkPass(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可审核通过");
    }

    public Result checkRefuse(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可审核拒绝");
    }

    @Override
    public Result checkRevoke(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可撤销审核");
    }

    public Result close(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可重复关闭");
    }

    public Result open(String activityId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activityId, currentStatus, Status.OPEN);
        return new Result("0000", "活动开启完成");
    }

    public Result doing(String activityId, Enum<Status> currentStatus) {
        return new Result("0001", "活动关闭不可变更活动中");
    }

}
