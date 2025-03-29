package cn.edu.tjufe.zql;


/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/25
 * @github https://github.com/little-seven-thirty
 */
public abstract class State {
    /**
     * 活动提审
     * @param activitiId 活动Id
     * @param currentStatus 活动状态
     * @return 活动信息结果
     */
    public abstract Result arraignment(String activitiId,Enum<Status> currentStatus);

    /**
     * 活动审核通过
     * @param activitiId 活动Id
     * @param currentStatus 活动状态
     * @return 活动信息结果
     */
    public abstract Result checkPass(String activitiId,Enum<Status> currentStatus);

    /**
     * 活动审核失败（拒审）
     * @param activitiId 活动Id
     * @param currentStatus 活动状态
     * @return 活动信息结果
     */
    public abstract Result checkRefuse(String activitiId,Enum<Status> currentStatus);

    /**
     * 活动撤审
     * @param activitiId 活动Id
     * @param currentStatus 活动状态
     * @return 活动信息结果
     */
    public abstract Result checkRevoke(String activitiId,Enum<Status> currentStatus);

    /**
     * 活动关闭
     * @param activitiId 活动Id
     * @param currentStatus 活动状态
     * @return 活动信息结果
     */
    public abstract Result close(String activitiId,Enum<Status> currentStatus);

    /**
     * 活动开启
     * @param activitiId 活动Id
     * @param currentStatus 活动状态
     * @return 活动信息结果
     */
    public abstract Result open(String activitiId,Enum<Status> currentStatus);

    /**
     * 活动正在执行中
     * @param activitiId 活动Id
     * @param currentStatus 活动状态
     * @return 活动信息结果
     */
    public abstract Result doing(String activitiId,Enum<Status> currentStatus);
}
