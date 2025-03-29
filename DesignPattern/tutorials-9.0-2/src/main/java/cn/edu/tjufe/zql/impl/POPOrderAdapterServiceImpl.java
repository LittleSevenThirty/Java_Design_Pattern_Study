package cn.edu.tjufe.zql.impl;

import cn.edu.tjufe.zql.OrderAdapterService;
import cn.edu.tjufe.zql.service.POPOrderService;

public class POPOrderAdapterServiceImpl implements OrderAdapterService {
    private POPOrderService popOrderService=new POPOrderService();


    @Override
    public boolean isFirst(String uId) {
        return popOrderService.isFirstOrder(uId);
    }
}
