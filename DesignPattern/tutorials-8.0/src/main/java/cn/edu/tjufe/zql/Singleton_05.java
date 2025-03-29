package cn.edu.tjufe.zql;

/**
 * 双重校验锁（线程安全）
 */
public class Singleton_05 {
    private static volatile Singleton_05 INSTANCE;  // 第一重锁

    private Singleton_05() {}

    public static Singleton_05 getInstance() {
        if(null!=INSTANCE) return INSTANCE;
        synchronized(Singleton_05.class){           // 第二重锁
            if(null==INSTANCE)INSTANCE = new Singleton_05();
        }
        return INSTANCE;
    }
}
