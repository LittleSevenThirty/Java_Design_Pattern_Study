package cn.edu.tjufe.zql;

import junit.framework.TestCase;
import org.junit.Test;

public class BuilderTest extends TestCase {
    @Test
    public void test_Builder(){
        Builder builder = new Builder();
        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());
        // 轻奢田园
        System.out.println(builder.levelTwo(98.25D).getDetail());
        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());

        // 我的
        System.out.println(builder.levelMy(79.8).getDetail());
    }
}