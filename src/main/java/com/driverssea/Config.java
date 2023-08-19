package com.driverssea;

import com.driverssea.services.OrdersBusinessService1;
import com.driverssea.services.OrdersBusinessServiceInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Primary
public class Config {
    @Bean(name="OrdersController")
    public OrdersBusinessServiceInterface getOrderBusinessService(){

        return new OrdersBusinessService1();
    }
}
