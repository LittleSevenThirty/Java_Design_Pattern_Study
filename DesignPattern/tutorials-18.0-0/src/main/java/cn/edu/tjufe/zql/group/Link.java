package cn.edu.tjufe.zql.group;


/**
 *
 * @authro 钟奇林
 * @description 节点链路
 * @date 2025/3/23
 * @github https://github.com/little-seven-thirty
 */
public class Link {
    private String fromUId; // 来源Uid
    private String toUId;   // 去往Uid

    public Link(String fromUId, String toUId) {
        this.fromUId = fromUId;
        this.toUId = toUId;
    }

    public String getFromUId() {
        return fromUId;
    }

    public void setFromUId(String fromUId) {
        this.fromUId = fromUId;
    }

    public String getToUId() {
        return toUId;
    }

    public void setToUId(String toUId) {
        this.toUId = toUId;
    }
}
