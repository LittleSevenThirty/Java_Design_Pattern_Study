package cn.edu.tjufe.zql.impl;


import cn.edu.tjufe.zql.ActivityService;
import cn.edu.tjufe.zql.Result;
import cn.edu.tjufe.zql.State;
import cn.edu.tjufe.zql.Status;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/25
 * @github https://github.com/little-seven-thirty
 */
public class EditingState extends State {
    @Override
    public Result arraignment(String activitiId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activitiId,currentStatus,Status.CHECK);
        return new Result("0000","活动提审成功");
    }

    @Override
    public Result checkPass(String activitiId, Enum<Status> currentStatus) {
        return new Result("0001","编辑中不可审核通过");
    }

    @Override
    public Result checkRefuse(String activitiId, Enum<Status> currentStatus) {
        return new Result("0001","编辑中不可审核拒绝");
    }

    @Override
    public Result checkRevoke(String activitiId, Enum<Status> currentStatus) {
        return new Result("0001","编辑中不可撤销审核");
    }

    @Override
    public Result close(String activitiId, Enum<Status> currentStatus) {
        ActivityService.execStatus(activitiId,currentStatus,Status.CLOSE);
        return new Result("0000","活动关闭成功");
    }

    @Override
    public Result open(String activitiId, Enum<Status> currentStatus) {
        return new Result("0001","非关闭活动不可开启");
    }

    @Override
    public Result doing(String activitiId, Enum<Status> currentStatus) {
        return new Result("0001","编辑活动不可执行活动中变更");
    }
}
