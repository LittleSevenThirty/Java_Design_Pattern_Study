package cn.edu.tjufe.zql.service.engine.impl;

import cn.edu.tjufe.zql.model.agreegates.TreeRich;
import cn.edu.tjufe.zql.model.vo.EngineResult;
import cn.edu.tjufe.zql.model.vo.TreeNode;
import cn.edu.tjufe.zql.service.engine.BaseEngine;

import java.util.Map;

public class TreeEngineHandle extends BaseEngine {

    @Override
    public EngineResult process(Long treeId, String userId, TreeRich treeRich, Map<String, String> decisionMatter) {
        // 决策流程
        TreeNode treeNode = engineDecisionMaker(treeRich, treeId, userId, decisionMatter);
        // 决策结果
        return new EngineResult(userId, treeId, treeNode.getTreeNodeId(), treeNode.getNodeValue());
    }

}
