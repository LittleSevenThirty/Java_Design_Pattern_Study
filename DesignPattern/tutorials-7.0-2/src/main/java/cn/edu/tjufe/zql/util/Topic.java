package cn.edu.tjufe.zql.util;

import java.util.Map;

/**
 * 选择题部分题目类：包含选项和答案
 */
public class Topic {
    private Map<String,String> options; // 选项：A、B、C、D
    private String key;                 // 答案

    public Topic() {
    }

    public Topic(Map<String, String> options, String key) {
        this.options = options;
        this.key = key;
    }

    public Map<String, String> getOptions() {
        return options;
    }

    public void setOptions(Map<String, String> options) {
        this.options = options;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
