package cn.edu.tjufe.zql.service.engine;

import cn.edu.tjufe.zql.model.agreegates.TreeRich;
import cn.edu.tjufe.zql.model.vo.EngineResult;

import java.util.Map;

public interface IEngine {
    EngineResult process(final Long treeId, final String userId, TreeRich treeRich, final Map<String, String> decisionMatter);
}
