package cn.edu.tjufe.zql.utils;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 模拟Redis数据库
 */
public class RedisUtils {
    // ScheduledExecutorService是Java并发包（java.util.concurrent）中的一个接口，
    // 它继承自ExecutorService接口。它主要用于调度命令在给定的延迟后运行，或者定期执行
    private ScheduledExecutorService scheduledExecutorService= Executors.newScheduledThreadPool(1);

    //AtomicInteger是Java并发包（java.util.concurrent.atomic）中的一个类，
    //提供了用于执行整数操作的原子方法。原子操作意味着这些操作是不可分割的，即它们要么全部执行，要么全部不执行，不会被线程调度机制打断。
    private AtomicInteger stock = new AtomicInteger(0);

    public RedisUtils(){
        scheduledExecutorService.scheduleAtFixedRate(()->{
            // 模拟库存消耗
            stock.addAndGet(1);
        },0,100000, TimeUnit.MICROSECONDS);
    }

    public int getStockUsed(){
        return stock.get();
    }
}
