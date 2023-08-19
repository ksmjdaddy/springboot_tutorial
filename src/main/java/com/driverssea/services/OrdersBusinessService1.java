package com.driverssea.services;

import com.driverssea.data.OrdersDataAccessInterface;
import com.driverssea.model.OrderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrdersBusinessService1 implements OrdersBusinessServiceInterface{

    @Autowired
    OrdersDataAccessInterface ordersDAO;

    @Override
    public void test() {
        System.out.println("Working");
    }

    @Override
    public OrderModel getById(long ID) {
        return ordersDAO.getById(ID);
    }

    @Override
    public List<OrderModel> getOrders() {

        return ordersDAO.getOrders();
    }

    @Override
    public List<OrderModel> searchOrders(String term) {
        return ordersDAO.searchOrders(term);
    }

    @Override
    public long addOne(OrderModel newOrder) {
        return ordersDAO.addOne(newOrder);
    }

    @Override
    public boolean deleteOne(long ID) {
        return ordersDAO.deleteOne(ID);
    }

    @Override
    public OrderModel updateOne(long IDToUpdate, OrderModel updateOrder) {
        return ordersDAO.updateOne(IDToUpdate,updateOrder);
    }
}
