package cn.edu.tjufe.zql;

/**
 * 饿汉式（初始就线程安全）
 */
public class Singleton_03 {
    private static Singleton_03 instance = new Singleton_03();

    private Singleton_03() {}

    public static Singleton_03 getInstance() {
        return instance;
    }
}
