package cn.edu.tjufe.zql;


import cn.edu.tjufe.zql.user.User;
import cn.edu.tjufe.zql.user.impl.Student;
import cn.edu.tjufe.zql.user.impl.Teacher;
import cn.edu.tjufe.zql.vistor.Vistor;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/27
 * @github https://github.com/little-seven-thirty
 */
public class DataView {
    List<User> userList = new ArrayList<User>();

    public DataView() {
        userList.add(new Student("谢飞机", "重点班", "一年一班"));
        userList.add(new Student("windy", "重点班", "一年一班"));
        userList.add(new Student("大毛", "普通班", "二年三班"));
        userList.add(new Student("Shing", "普通班", "三年四班"));
        userList.add(new Teacher("BK", "特级教师", "一年一班"));
        userList.add(new Teacher("娜娜Goddess", "特级教师", "一年一班"));
        userList.add(new Teacher("dangdang", "普通教师", "二年三班"));
        userList.add(new Teacher("泽东", "实习教师", "三年四班"));
    }

    public void show(Vistor visitor){
        for(User user : userList){
            user.accept(visitor);
        }
    }
}
