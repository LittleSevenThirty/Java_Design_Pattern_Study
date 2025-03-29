package cn.edu.tjufe.zql;

/**
 * 解答题类
 */
public class AnswerQuestion {
    private String name;    // 题目
    private String key;     // 答案

    public AnswerQuestion() {
    }

    public AnswerQuestion(String name, String key) {
        this.name = name;
        this.key = key;
    }

    // get,set 方法

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
