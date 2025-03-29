package cn.edu.tjufe.zql;

/**
 * 商品存货类
 */
public class Stock {
    private long total; // 库存总量
    private long used;  // 已消耗量

    public Stock(int total, int used) {
        this.total = total;
        this.used = used;
    }
    // ...get/set

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getUsed() {
        return used;
    }

    public void setUsed(long used) {
        this.used = used;
    }
}
