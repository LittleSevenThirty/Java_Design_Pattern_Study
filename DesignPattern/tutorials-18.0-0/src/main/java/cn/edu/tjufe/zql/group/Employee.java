package cn.edu.tjufe.zql.group;


/**
 *
 * @authro 钟奇林
 * @description 雇员信息类
 * @date 2025/3/23
 * @github https://github.com/little-seven-thirty
 */
public class Employee {
    private String uId;     // 雇员Id
    private String name;    // 雇员姓名
    private String desc;    // 备注

    // 构造
    public Employee(String uId, String name, String desc) {
        this.uId = uId;
        this.name = name;
        this.desc = desc;
    }

    public Employee(String uId,String name){
        this(uId,name,null);
    }

    // ...get/set
    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
