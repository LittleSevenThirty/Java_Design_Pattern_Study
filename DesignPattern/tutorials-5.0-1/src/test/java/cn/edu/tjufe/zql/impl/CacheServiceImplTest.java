package cn.edu.tjufe.zql.impl;

import cn.edu.tjufe.zql.CacheService;
import junit.framework.TestCase;
import org.junit.Test;

public class CacheServiceImplTest extends TestCase {

    @Test
    public void testGet() {
        CacheService cacheService = new CacheServiceImpl();
        cacheService.set("user_nameTeste_00","钟奇林",1);
        String name=cacheService.get("user_nameTeste_00",1);
        System.out.println(name);
    }

    public void testSet() {
    }

    public void testTestSet() {
    }

    public void testDel() {
    }
}