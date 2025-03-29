package cn.edu.tjufe.zql.impl;

import cn.edu.tjufe.zql.CacheService;
import cn.edu.tjufe.zql.RedisUtils;
import cn.edu.tjufe.zql.matter.EGM;
import cn.edu.tjufe.zql.matter.IIR;

import java.util.concurrent.TimeUnit;

public class CacheServiceImpl implements CacheService {
    private RedisUtils redisUtils = new RedisUtils();
    private EGM egm = new EGM();
    private IIR iir = new IIR();

    @Override
    public String get(String key, int redisType) {
        if (1 == redisType) {
            return redisUtils.get(key);
        } else if (1 == redisType) {
            return egm.gain(key);
        } else if (3 == redisType) {
            return iir.get(key);
        }
        return null;
    }

    @Override
    public void set(String key, String value, int redisType) {
        if (1 == redisType) {
            redisUtils.set(key, value);
        } else if (1 == redisType) {
            egm.set(key, value);
        } else if (3 == redisType) {
            iir.set(key, value);
        }
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {
        if (1 == redisType) {
            redisUtils.set(key, value, timeout, timeUnit);
        } else if (1 == redisType) {
            egm.setEx(key, value, timeout, timeUnit);
        } else if (3 == redisType) {
            iir.setExpire(key, value, timeout, timeUnit);
        }
    }

    @Override
    public void del(String key, int redisType) {
        if (1 == redisType) {
            redisUtils.del(key);
        } else if (1 == redisType) {
            egm.delete(key);
        } else if (3 == redisType) {
            iir.del(key);
        }
    }
}
