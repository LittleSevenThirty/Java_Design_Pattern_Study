package cn.edu.tjufe.zql;

import cn.edu.tjufe.zql.impl.InsideOrderServiceImpl;
import cn.edu.tjufe.zql.impl.POPOrderAdapterServiceImpl;
import junit.framework.TestCase;
import org.junit.Test;

public class OrderAdapterServiceTest extends TestCase {
    @Test
    public void test_itfAdapter() {
        OrderAdapterService popOrderAdapterService = new POPOrderAdapterServiceImpl();
        System.out.println("判断首单，接口适配(POP)：" + popOrderAdapterService.isFirst("100001"));

        OrderAdapterService insideOrderService = new InsideOrderServiceImpl();
        System.out.println("判断首单，接口适配(自营)：" + insideOrderService.isFirst("100001"));
    }
}