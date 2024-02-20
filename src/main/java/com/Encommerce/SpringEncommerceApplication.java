package com.Encommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SpringEncommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringEncommerceApplication.class, args);
	
               
        }

}
