package cn.edu.tjufe.zql;


/**
 *
 * @authro 钟奇林
 * @description 活动状态变更控制器类
 * @date 2025/3/25
 * @github https://github.com/little-seven-thirty
 */
public class ActivityExecStatusController {
    /**
     * 活动状态变更
     * 1. 编辑中 -> 提审、关闭
     * 2. 审核通过 -> 拒绝、关闭、活动中
     * 3. 审核拒绝 -> 撤审、关闭
     * 4. 活动中 -> 关闭
     * 5. 活动关闭 -> 开启
     * 6. 活动开启 -> 关闭
     *
     * @param activityId   活动ID
     * @param beforeStatus 变更前状态
     * @param afterStatus  变更后状态
     * @return 返回结果
     */
    public Result execStatus(String activityId,Enum<Status> beforeStatus,Enum<Status> afterStatus){
        // 编辑中 -> 提审、关闭
        if(Status.EDITING.equals(beforeStatus)){
            if(Status.CHECK.equals(afterStatus)||Status.CLOSE.equals(afterStatus)){
                ActivityService.execStatus(activityId,beforeStatus,afterStatus);
                return new Result("0000","状态变更成功");
            }else{
                return new Result("0001","状态变更失败");
            }
        }
        // 审核通过 -> 拒绝、关闭、活动中
        if(Status.PASS.equals(beforeStatus)){
            if(Status.REFUSE.equals(afterStatus)||Status.CLOSE.equals(afterStatus)||Status.DOING.equals(afterStatus)){
                ActivityService.execStatus(activityId,beforeStatus,afterStatus);
                return new Result("0000","状态变更成功");
            }else{
                return new Result("0001","状态变更失败");
            }
        }
        // 审核拒绝 -> 撤审、关闭
        if(Status.REFUSE.equals(beforeStatus)){
            if(Status.EDITING.equals(afterStatus)||Status.CLOSE.equals(afterStatus)){
                ActivityService.execStatus(activityId,beforeStatus,afterStatus);
                return new Result("0000","状态变更成功");
            }else{
                return new Result("0001","状态变更失败");
            }
        }
        // 活动中 -> 关闭
        if(Status.DOING.equals(beforeStatus)){
            if(Status.CLOSE.equals(afterStatus)){
                ActivityService.execStatus(activityId,beforeStatus,afterStatus);
                return new Result("0000","状态变更成功");
            }else{
                return new Result("0001","状态变更失败");
            }
        }
        // 活动关闭 -> 开启
        if(Status.CLOSE.equals(beforeStatus)){
            if(Status.OPEN.equals(afterStatus)){
                ActivityService.execStatus(activityId,beforeStatus,afterStatus);
                return new Result("0000","状态变更成功");
            }else{
                return new Result("0001","状态变更失败");
            }
        }
        // 活动开启 -> 关闭
        if(Status.OPEN.equals(beforeStatus)){
            if(Status.CLOSE.equals(afterStatus)){
                ActivityService.execStatus(activityId,beforeStatus,afterStatus);
                return new Result("0000","状态变更成功");
            }else{
                return new Result("0001","状态变更失败");
            }
        }

        return new Result("0001","非可处理活动状态变更");
    }
}
