package cn.edu.tjufe.zql.agent;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {
    String value() default "";      // Sql语句
}
