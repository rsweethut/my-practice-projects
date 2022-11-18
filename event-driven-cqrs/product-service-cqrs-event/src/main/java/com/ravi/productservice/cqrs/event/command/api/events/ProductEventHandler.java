package com.ravi.productservice.cqrs.event.command.api.events;

import com.ravi.productservice.cqrs.event.command.api.data.Product;
import com.ravi.productservice.cqrs.event.command.api.data.ProductRepository;
import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.axonframework.messaging.interceptors.ExceptionHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@ProcessingGroup("Product")
public class ProductEventHandler {

    public ProductEventHandler(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    private ProductRepository productRepository;
    @EventHandler
    public void on(ProductCreateEvent productCreateEvent) throws Exception {
        Product product = new Product();
        BeanUtils.copyProperties(productCreateEvent,product);
        productRepository.save(product);

        throw new Exception("Exception Occurred!!!!");
    }

    @ExceptionHandler
    public void handle(Exception exception) throws Exception {
        throw exception;
    }
}
