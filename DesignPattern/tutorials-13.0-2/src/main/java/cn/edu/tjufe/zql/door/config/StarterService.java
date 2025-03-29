package cn.edu.tjufe.zql.door.config;

import org.springframework.util.StringUtils;

public class StarterService {
    private String userStr;     // 前端请求返回Id

    public StarterService(String userStr) {
        this.userStr = userStr;
    }

    /**
     * 根据分割字符串，分割被分割字符串
     * @param separatorChar 分割字符串
     * @return  已被分割字符串数组
     */
    public String[] split(String separatorChar){
        return StringUtils.split(this.userStr,separatorChar);
    }
}
