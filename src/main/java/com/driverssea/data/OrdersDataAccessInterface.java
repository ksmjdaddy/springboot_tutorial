package com.driverssea.data;

import com.driverssea.model.OrderModel;

import java.util.List;

public interface OrdersDataAccessInterface {
    public OrderModel getById(long ID);
    public void Init();
    public void Destroy();
    public List<OrderModel> getOrders();
    public List<OrderModel> searchOrders(String term);
    public long addOne(OrderModel newOrder);
    public boolean deleteOne(long ID);
    public OrderModel updateOne(long IDToUpdate, OrderModel updateOrder);
}
