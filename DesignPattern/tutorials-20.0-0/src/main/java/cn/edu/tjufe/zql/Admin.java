package cn.edu.tjufe.zql;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @authro 钟奇林
 * @description 管理员类
 * @date 2025/3/24
 * @github https://github.com/little-seven-thirty
 */
public class Admin {
    private int cursorIdx=0;
    private List<ConfigMemento> configMementos=new ArrayList<ConfigMemento>();  // 通过回退前进来更新配置文件
    private Map<String,ConfigMemento> configMementosMap=new ConcurrentHashMap<>();  // 通过版本号来更新配置文件

    public void appendMemento(ConfigMemento memento){
        configMementos.add(memento);
        configMementosMap.put(memento.getConfigFile().getVersionNo(),memento);
        cursorIdx++;
    }

    public ConfigMemento undoMemento(){
        if(--cursorIdx<=0)return configMementos.get(0);
        return configMementos.get(cursorIdx);
    }

    public ConfigMemento redoMemento(){
        if(++cursorIdx>configMementos.size())return configMementos.get(configMementos.size()-1);
        return configMementos.get(cursorIdx);
    }

    public ConfigMemento getMementoByVersion(String version){
        if(null!=version)return configMementosMap.get(version);
        return null;
    }
}
