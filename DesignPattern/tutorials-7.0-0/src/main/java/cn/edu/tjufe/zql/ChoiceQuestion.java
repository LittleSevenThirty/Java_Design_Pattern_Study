package cn.edu.tjufe.zql;

import java.util.Map;

/**
 * 选择题类
 */
public class ChoiceQuestion {
    private String name;            // 题目内容
    private Map<String,String> options; // 选项：A、B、C、D
    private String key;              // 答案

    public ChoiceQuestion() {
    }

    public ChoiceQuestion(String name, Map<String, String> options, String key) {
        this.name = name;
        this.options = options;
        this.key = key;
    }
// get,set方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
