package com.ravi.productservice.cqrs.event.command.api.controller;

import com.ravi.productservice.cqrs.event.command.api.commands.CreateProductCommand;
import com.ravi.productservice.cqrs.event.command.api.model.ProductRestModel;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductCommandController {

    private CommandGateway commandGateway;

    public ProductCommandController(CommandGateway commandGateway) {
        this.commandGateway = commandGateway;
    }

    @PostMapping("/")
    public String addProduct(@RequestBody ProductRestModel productRestModel)
    {
        CreateProductCommand createProductCommand = CreateProductCommand.builder()
                .productId(UUID.randomUUID().toString())
                .productName(productRestModel.getProductName())
                .productPriceTag(productRestModel.getProductPriceTag())
                .productQuantity(productRestModel.getProductQuantity())
                .build();
        String result = commandGateway.sendAndWait(createProductCommand);
        return result;
    }
}
