package cn.edu.tjufe.zql;


/**
 * 审核信息类
 * @authro 钟奇林
 * @description 这个类是包装了责任链处理过程中返回结果的类，方便处理每个责任链的返回信息
 * @date 2025/3/22
 * @github https://github.com/little-seven-thirty
 */
public class AuthInfo {
    private String code;
    private String info = "";

    public AuthInfo(String code,String ...infos){
        this.code = code;
        for(String temp:infos){
            info=info.concat(temp);
        }
    }

    // ...get/set
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
