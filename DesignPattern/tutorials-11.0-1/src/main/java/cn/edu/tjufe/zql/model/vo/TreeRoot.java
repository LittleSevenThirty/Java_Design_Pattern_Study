package cn.edu.tjufe.zql.model.vo;

/**
 * 规则树跟信息
 */
public class TreeRoot {
    private Long treeId;    // 规则树Id
    private Long treeRootNodeId;    // 规则树根Id
    private String treeName;        // 规则树名称

    // ...get/set

    public Long getTreeId() {
        return treeId;
    }

    public void setTreeId(Long treeId) {
        this.treeId = treeId;
    }

    public Long getTreeRootNodeId() {
        return treeRootNodeId;
    }

    public void setTreeRootNodeId(Long treeRootNodeId) {
        this.treeRootNodeId = treeRootNodeId;
    }

    public String getTreeName() {
        return treeName;
    }

    public void setTreeName(String treeName) {
        this.treeName = treeName;
    }
}
