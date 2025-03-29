package cn.edu.tjufe.zql;


import cn.edu.tjufe.zql.impl.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/26
 * @github https://github.com/little-seven-thirty
 */
public class StateController {
    private Map<Enum<Status>, State> stateMap = new ConcurrentHashMap<Enum<Status>, State>();

    public StateController() {
        stateMap.put(Status.CHECK, new CheckState());
        stateMap.put(Status.CLOSE, new CloseState());
        stateMap.put(Status.DOING, new DoingState());
        stateMap.put(Status.EDITING, new EditingState());
        stateMap.put(Status.OPEN, new OpenState());
        stateMap.put(Status.PASS, new PassState());
        stateMap.put(Status.REFUSE, new RefuseState());
    }
    
    public Result arraignment(String activitiId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).arraignment(activitiId, currentStatus);
    }
    
    public Result checkPass(String activitiId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkPass(activitiId, currentStatus);
    }
    
    public Result checkRefuse(String activitiId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRefuse(activitiId, currentStatus);
    }
    
    public Result checkRevoke(String activitiId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).checkRevoke(activitiId, currentStatus);
    }
    
    public Result close(String activitiId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).close(activitiId, currentStatus);
    }
    
    public Result open(String activitiId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).open(activitiId, currentStatus);
    }
    
    public Result doing(String activitiId, Enum<Status> currentStatus) {
        return stateMap.get(currentStatus).doing(activitiId, currentStatus);
    }
}
