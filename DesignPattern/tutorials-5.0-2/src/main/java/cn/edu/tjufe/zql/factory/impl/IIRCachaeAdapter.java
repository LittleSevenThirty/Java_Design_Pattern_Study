package cn.edu.tjufe.zql.factory.impl;

import cn.edu.tjufe.zql.factory.ICacheAdapter;
import cn.edu.tjufe.zql.matter.IIR;

import java.util.concurrent.TimeUnit;
public class IIRCachaeAdapter implements ICacheAdapter {

    private IIR iir=new IIR();

    @Override
    public String get(String key) {
        return iir.get(key);
    }

    @Override
    public void set(String key, String value) {
        iir.set(key, value);
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit) {
        iir.setExpire(key, value, timeout, timeUnit);
    }

    @Override
    public void del(String key) {
        iir.del(key);
    }
}
