package cn.edu.tjufe.zql.door.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 切面定义
 * @author: zql
 */
@ConfigurationProperties("itstack.door")
public class StarterServiceProperties {
    private String userStr;

    public String getUserStr() {
        return userStr;
    }

    public void setUserStr(String userStr) {
        this.userStr = userStr;
    }
}
