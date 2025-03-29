package cn.edu.tjufe.zql.user;


import cn.edu.tjufe.zql.vistor.Vistor;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/26
 * @github https://github.com/little-seven-thirty
 */
public abstract class User {
    // 姓名
    public String name;
    // 身份：重点班、普通班 | 特级教师、普通教师、实习教师
    public String identity;
    // 班级
    public String clazz;

    public User(String name, String identity, String clazz) {
        this.name = name;
        this.identity = identity;
        this.clazz = clazz;
    }

    public abstract void accept(Vistor vistor);
}
