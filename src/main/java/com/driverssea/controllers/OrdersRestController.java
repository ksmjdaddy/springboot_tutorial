package com.driverssea.controllers;

import com.driverssea.model.OrderModel;
import com.driverssea.services.OrdersBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrdersRestController {

    OrdersBusinessServiceInterface service;

    @Autowired
    public OrdersRestController(OrdersBusinessServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public List<OrderModel> showAllOrders(){
        return service.getOrders();
    }

    @GetMapping("/search/{searchTerm}")
    public List<OrderModel> searchOrders(@PathVariable(name="searchTerm") String searchTerm){
        List<OrderModel> results = service.searchOrders(searchTerm);
        return results;
    }

    @GetMapping("/test/{searchTerm}")
    public String test(@PathVariable(name="searchTerm") String searchTerm){
        return searchTerm;
    }


    @PostMapping("/")
    public long addOrder(@RequestBody OrderModel model){
        return service.addOne(model);
    }

    @GetMapping("/{ID}")
    public OrderModel getByID(@PathVariable(name="ID") long ID){
        return service.getById(ID);
    }

    @GetMapping("/delete/{ID}")
    public boolean deleteByID(@PathVariable(name="ID") long ID){
        return service.deleteOne(ID);
    }

    @PutMapping("/update/{ID}")
    public OrderModel addOrder(@RequestBody OrderModel model, @PathVariable(name="ID") long ID){
        return service.updateOne(ID, model);
    }

}
