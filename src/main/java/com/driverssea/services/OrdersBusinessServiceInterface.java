package com.driverssea.services;

import com.driverssea.data.OrdersDataAccessInterface;
import com.driverssea.model.OrderModel;

import java.util.List;

public interface OrdersBusinessServiceInterface {

    public void test();

    public OrderModel getById(long ID);
    public List<OrderModel> getOrders();
    public List<OrderModel> searchOrders(String term);
    public long addOne(OrderModel newOrder);
    public boolean deleteOne(long ID);
    public OrderModel updateOne(long IDToUpdate, OrderModel updateOrder);
}
