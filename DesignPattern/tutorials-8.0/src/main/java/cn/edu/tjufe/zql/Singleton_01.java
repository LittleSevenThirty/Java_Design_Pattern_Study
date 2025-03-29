package cn.edu.tjufe.zql;

/**
 * 懒汉式：非线程安全
 */
public class Singleton_01 {
    private static Singleton_01 instance;

    private Singleton_01() {
    }

    public static Singleton_01 getInstance() {
        if (null != instance) return instance;
        instance = new Singleton_01();
        return instance;
    }
}
