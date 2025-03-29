package cn.edu.tjufe.zql.user.impl;


import cn.edu.tjufe.zql.user.User;
import cn.edu.tjufe.zql.vistor.Vistor;

import java.math.BigDecimal;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/26
 * @github https://github.com/little-seven-thirty
 */
public class Student extends User {
    public Student(String name, String identity, String clazz) {
        super(name, identity, clazz);
    }

    @Override
    public void accept(Vistor vistor) {
        vistor.visitor(this);
    }

    public int ranking(){
        return (int)(Math.random()*100);
    }
}
