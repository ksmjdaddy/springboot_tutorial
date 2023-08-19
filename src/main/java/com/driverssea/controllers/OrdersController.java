package com.driverssea.controllers;

import com.driverssea.model.OrderModel;
import com.driverssea.services.OrdersBusinessService1;
import com.driverssea.services.OrdersBusinessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {

    OrdersBusinessServiceInterface service;

    @Autowired
    public OrdersController(OrdersBusinessServiceInterface service) {
        this.service = service;
    }

    @GetMapping
    public String showAllOrders(Model model){
        model.addAttribute("title","Here is what I want to do this summer");
        model.addAttribute("orders",service.getOrders());
        return "orders";
    }
}
