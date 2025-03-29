package cn.edu.tjufe.zql;


import java.util.Date;

/**
 *
 * @authro 钟奇林
 * @description 配置文件类
 * @date 2025/3/24
 * @github https://github.com/little-seven-thirty
 */
public class ConfigFile {
    // 版本号
    private String versionNo;
    // 内容
    private String content;
    // 时间
    private Date dateTime;
    // 操作人
    private String operator;

    public ConfigFile(String versionNo, String content, Date dateTime, String operator) {
        this.versionNo = versionNo;
        this.content = content;
        this.dateTime = dateTime;
        this.operator = operator;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
