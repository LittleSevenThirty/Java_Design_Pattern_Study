package cn.edu.tjufe.zql.vistor.impl;


import cn.edu.tjufe.zql.user.impl.Student;
import cn.edu.tjufe.zql.user.impl.Teacher;
import cn.edu.tjufe.zql.vistor.Vistor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @authro 钟奇林
 * @description
 * @date 2025/3/26
 * @github https://github.com/little-seven-thirty
 */
public class Principal implements Vistor {
    private Logger logger = LoggerFactory.getLogger(Principal.class);

    public void visitor(Student student) {
        logger.info("学生信息 姓名：{} 班级：{}", student.name, student.clazz);
    }

    public void visitor(Teacher teacher) {
        logger.info("学生信息 姓名：{} 班级：{} 升学率：{}", teacher.name, teacher.clazz, teacher.entranceRatio());
    }
}
