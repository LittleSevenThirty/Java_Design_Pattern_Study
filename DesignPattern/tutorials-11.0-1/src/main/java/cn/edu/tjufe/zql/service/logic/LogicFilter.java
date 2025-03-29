package cn.edu.tjufe.zql.service.logic;

import cn.edu.tjufe.zql.model.vo.TreeNodeLink;

import java.util.List;
import java.util.Map;

/**
 * 逻辑过滤器接口
 */
public interface LogicFilter {
    /**
     * 获取决策值
     * @param treeId
     * @param userId
     * @param decisionMatter    决策事情
     * @return 决策值
     */
    String matterValue(Long treeId, String userId, Map<String,String> decisionMatter);

    /**
     * 逻辑决策器
     *
     * @param matterValue  决策值
     * @param treeNodeLineInfoList  决策节点
     * @return  下一个节点Id
     */
    Long filter(String matterValue, List<TreeNodeLink> treeNodeLineInfoList);
}
