package com.driverssea.data;

import com.driverssea.model.OrderModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderFakeDAO implements OrdersDataAccessInterface{
    List<OrderModel> orders;

    public OrderFakeDAO() {
        orders = new ArrayList<>();
        orders.add(new OrderModel(0L, "000", "Sky Diving Experience", 1500.0f, 1));
        orders.add(new OrderModel(1L, "001", "Ride a bike", 150.0f, 1));
        orders.add(new OrderModel(2L, "002", "Jump off the moon", 1500000.0f, 1));
        orders.add(new OrderModel(3L, "003", "Go Jelly Fishing", 15.0f, 1));
        orders.add(new OrderModel(4L, "004", "Spend da day with Sponge Bob", 1.25f, 1));
        orders.add(new OrderModel(5L, "005", "Say hi to Johns mom", 0.0f, 1));
        orders.add(new OrderModel(6L, "006", "Celebrate my birthday", 15000.0f, 1));
        orders.add(new OrderModel(7L, "007", "Celebrate Johns birthday", 100.0f, 1));
        orders.add(new OrderModel(8L, "008", "Buy a house", 190000.0f, 1));
        orders.add(new OrderModel(9L, "009", "Drive a car off a cliff just to watch it explode", 15000.0f, 1));
        orders.add(new OrderModel(10L, "010", "Go to Hanging Rock", 500.0f, 1));
    }

    @Override
    public OrderModel getById(long ID) {
        for(OrderModel order : orders){
            if(order.getID()==ID)return order;
        }
        return null;
    }

    @Override
    public void Init() {

    }

    @Override
    public void Destroy() {

    }

    @Override
    public List<OrderModel> getOrders() {
        return orders;
    }

    @Override
    public List<OrderModel> searchOrders(String term) {
        return orders.stream().filter(order->order.getProductName().toLowerCase().contains(term.toLowerCase())).collect(Collectors.toList());
    }

    @Override
    public long addOne(OrderModel newOrder) {
        orders.add(newOrder);
        return orders.size();
    }

    @Override
    public boolean deleteOne(long ID) {
        for(OrderModel order : orders){
            if(order.getID()==ID){
                orders.remove(order);
                return true;
            }
        }
        return false;
    }

    @Override
    public OrderModel updateOne(long IDToUpdate, OrderModel updateOrder) {
        for(OrderModel order : orders){
            if(order.getID()==IDToUpdate){
                int i=orders.indexOf(order);
                orders.set(i, updateOrder);
                return orders.get(i);
            }
        }
        return null;
    }
}
