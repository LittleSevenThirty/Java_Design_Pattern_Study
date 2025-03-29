package cn.edu.tjufe.zql.vistor;

import cn.edu.tjufe.zql.user.impl.Student;
import cn.edu.tjufe.zql.user.impl.Teacher;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/26
 * @github https://github.com/little-seven-thirty
 */
public interface Vistor {
    // 访问学生
    void visitor(Student student);

    // 访问老师
    void visitor(Teacher teacher);
}
