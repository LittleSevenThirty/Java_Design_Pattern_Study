package cn.edu.tjufe.zql;


/**
 *
 * @authro 钟奇林
 * @description 存放状态结果的类
 * @date 2025/3/25
 * @github https://github.com/little-seven-thirty
 */
public class Result {
    // 编码
    private String code;
    // 描述
    private String desc;

    public Result(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
