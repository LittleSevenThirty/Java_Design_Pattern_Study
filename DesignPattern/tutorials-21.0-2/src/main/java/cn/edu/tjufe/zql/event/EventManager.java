package cn.edu.tjufe.zql.event;


import cn.edu.tjufe.zql.LotteryResult;
import cn.edu.tjufe.zql.event.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @authro 钟奇林
 * @description 事件管理类
 * @date 2025/3/24
 * @github https://github.com/little-seven-thirty
 */
public class EventManager {
    public enum EventType{
        MESSAGE,
        MQ;
    }

    // 事件监听者列表映射
    private Map<Enum<EventType>, List<EventListener>> listenerListMap = new HashMap<>();

    public EventManager(Enum<EventType>...operations) {
        for(Enum<EventType> operation : operations) {
            this.listenerListMap.put(operation,new ArrayList<>());
        }
    }

    /**
     * 订阅事件监听
     * @param eventType 事件类型
     * @param listener  监听实体
     */
    public void subscribe(Enum<EventType> eventType, EventListener listener) {
        listenerListMap.get(eventType).add(listener);
    }

    /**
     * 取消事件监听订阅
     * @param eventType 事件类型
     * @param listener  监听实体
     */
    public void unsubscribe(Enum<EventType> eventType, EventListener listener) {
        listenerListMap.get(eventType).remove(listener);
    }

    /**
     * 事件通知
     * @param eventType 所要执行事件类型
     * @param result 所要监听事件，此事件可以更改
     */
    public void notify(Enum<EventType> eventType, LotteryResult result) {
        List<EventListener> listenerList = listenerListMap.get(eventType);
        for(EventListener listener : listenerList) {
            listener.doEvent(result);
        }
    }
}
