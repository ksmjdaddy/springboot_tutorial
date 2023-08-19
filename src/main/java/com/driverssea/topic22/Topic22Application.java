package com.driverssea.topic22;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.driverssea.model.*;
import com.driverssea.controllers.*;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.driverssea.*")
public class Topic22Application {

	public static void main(String[] args) {
		SpringApplication.run(Topic22Application.class, args);
	}

}
