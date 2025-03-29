package cn.edu.tjufe.zql.group;


import cn.edu.tjufe.zql.lang.Collection;
import cn.edu.tjufe.zql.lang.Iterator;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/23
 * @github https://github.com/little-seven-thirty
 */
public class GroupStructure implements Collection<Employee,Link> {
    //  * E -> Employee,L -> Link
    // 自身的成员属性
    private String groupId;                                         // 组织Id，一个组织链的头部
    private String groupName;                                       // 组织名称
    private Map<String,Employee> employeeMap = new ConcurrentHashMap<String,Employee>();        // 雇员映射表
    private Map<String, List<Link>> linkListMap = new ConcurrentHashMap<String,List<Link>>();   // 组织架构关系映射表 id -> list
    private Map<String,String>  invertedMap = new ConcurrentHashMap<String,String>();           // 反向关系链

    public GroupStructure(String groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }

    @Override
    public boolean add(Employee employee) {
        return null!=employeeMap.put(employee.getuId(), employee);
    }

    @Override
    public boolean remove(Employee employee) {
        return null!=employeeMap.remove(employee.getuId());
    }

    @Override
    public boolean addLink(String key, Link link) {
        // 维护反向关系链，便于后续遍历
        invertedMap.put(link.getToUId(),link.getFromUId());
        if(linkListMap.containsKey(key)){
            // 组织架构关系映射表已有该部门，只需向该部门后添加后续节点
            return linkListMap.get(key).add(link);  // 可直接返回插入结果
        }else{
            List<Link> newLinkList = new LinkedList<Link>();
            newLinkList.add(link);
            linkListMap.put(key,newLinkList);
            return true;
        }
    }

    @Override
    public boolean removeLink(String key) {
        return null!=linkListMap.remove(key);
    }

    @Override
    public Iterator<Employee> getIterator() {
        return new Iterator<Employee>(){

            HashMap<String,Integer> keyMap = new HashMap<String,Integer>();

            int totalIdx =0;        // ？：遍历下标
            private String fromId = groupId;     // 雇员ID，from
            private String toId = groupId;       // 雇员Id，to

            @Override
            public boolean hasNext() {
                return totalIdx < employeeMap.size();
            }

            @Override
            public Employee getNext() {
                List<Link> linkList = linkListMap.get(toId);
                int cursorIdx = getCursorIdx(toId);

                // 同级节点扫描
                if(null == linkList){
                    cursorIdx = getCursorIdx(fromId);
                    linkList = linkListMap.get(fromId);
                }

                // 上级节点扫描
                while(cursorIdx > linkList.size()-1){
                    fromId = invertedMap.get(fromId);
                    cursorIdx = getCursorIdx(fromId);
                    linkList = linkListMap.get(fromId);
                }

                // 获取节点
                Link link = linkList.get(cursorIdx);
                toId = link.getToUId();
                fromId = link.getFromUId();
                totalIdx++;

                return employeeMap.get(link.getToUId());
            }

            // 给每个层级定义宽度遍历
            public int getCursorIdx(String key){
                int idx =0;
                if(keyMap.containsKey(key)){
                    idx = keyMap.get(key);
                    keyMap.put(key,++idx);
                }else{
                    keyMap.put(key,idx);
                }
                return idx;
            }
        };
    }
}
