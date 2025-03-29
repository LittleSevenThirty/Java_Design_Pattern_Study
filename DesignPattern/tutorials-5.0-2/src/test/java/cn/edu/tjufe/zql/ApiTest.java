package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.factory.JDKProxy;
import cn.edu.tjufe.zql.factory.impl.EGMCacheAdapter;
import cn.edu.tjufe.zql.factory.impl.IIRCachaeAdapter;
import cn.edu.tjufe.zql.impl.CacheServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;

public class ApiTest extends TestCase {
    @Test
    public void test_CacheService() throws Exception {
        CacheService proxy_EGM = JDKProxy.getProxy(CacheServiceImpl.class, new EGMCacheAdapter());
        proxy_EGM.set("user_name_01","小傅哥",1);
        String val01 = proxy_EGM.get("user_name_01",1);
        System.out.println(val01);

        CacheService proxy_IIR = JDKProxy.getProxy(CacheServiceImpl.class, new IIRCachaeAdapter());
        proxy_IIR.set("user_name_01","小傅哥",1);
        String val02 = proxy_IIR.get("user_name_01",1);
        System.out.println(val02);
    }
}