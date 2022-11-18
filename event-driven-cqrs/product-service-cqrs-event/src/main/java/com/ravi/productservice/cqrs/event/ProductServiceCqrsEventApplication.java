package com.ravi.productservice.cqrs.event;

import com.ravi.productservice.cqrs.event.command.api.exception.ProductServiceEventErrorHandler;
import org.axonframework.config.EventProcessingConfigurer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceCqrsEventApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceCqrsEventApplication.class, args);
	}

	@Autowired
	public void configure(EventProcessingConfigurer configurer)
	{
		configurer.registerListenerInvocationErrorHandler("Product",configuration -> new ProductServiceEventErrorHandler());
	}

}
