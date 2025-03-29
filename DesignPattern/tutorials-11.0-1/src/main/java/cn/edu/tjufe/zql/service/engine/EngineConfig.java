package cn.edu.tjufe.zql.service.engine;

import cn.edu.tjufe.zql.service.logic.LogicFilter;
import cn.edu.tjufe.zql.service.logic.impl.UserAgeFilter;
import cn.edu.tjufe.zql.service.logic.impl.UserGenderFilter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class EngineConfig {
    static Map<String, LogicFilter> logicFilterMap;

    static {
        logicFilterMap = new ConcurrentHashMap<String, LogicFilter>();
        logicFilterMap.put("userAge",new UserAgeFilter());
        logicFilterMap.put("userGender",new UserGenderFilter());
    }

    public Map<String,LogicFilter> getLogicFilterMap(){
        return logicFilterMap;
    }

    public void setLogicFilterMap(Map<String,LogicFilter> logicFilterMap){
        this.logicFilterMap = logicFilterMap;
    }
}
