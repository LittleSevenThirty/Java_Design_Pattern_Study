package cn.edu.tjufe.zql.impl;

import cn.edu.tjufe.zql.OrderAdapterService;
import cn.edu.tjufe.zql.service.OrderService;

public class InsideOrderServiceImpl implements OrderAdapterService {
    private OrderService orderService = new OrderService();

    @Override
    public boolean isFirst(String uId){
        return orderService.queryUserOrderCount(uId)<=1;
    }
}