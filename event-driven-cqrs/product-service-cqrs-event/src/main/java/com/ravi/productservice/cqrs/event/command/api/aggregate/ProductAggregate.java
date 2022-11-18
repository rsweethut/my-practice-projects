package com.ravi.productservice.cqrs.event.command.api.aggregate;

import com.ravi.productservice.cqrs.event.command.api.commands.CreateProductCommand;
import com.ravi.productservice.cqrs.event.command.api.events.ProductCreateEvent;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;

import java.math.BigDecimal;

@Aggregate
public class ProductAggregate {

    @AggregateIdentifier
    private String productId;
    private String productName;
    private BigDecimal productPriceTag;
    private Integer productQuantity;

    @CommandHandler
    public ProductAggregate(CreateProductCommand createProductCommand) {

        /*ProductCreateEvent productCreateEvent = ProductCreateEvent.builder()
                .productId(createProductCommand.getProductId())
                .productName(createProductCommand.getProductName())
                .productPriceTag(createProductCommand.getProductPriceTag())
                .productQuantity(createProductCommand.getProductQuantity())
                .build();*/

        ProductCreateEvent productCreateEvent = new ProductCreateEvent();
        BeanUtils.copyProperties(createProductCommand,productCreateEvent);

        AggregateLifecycle.apply(productCreateEvent);
    }
    public ProductAggregate() {
    }

    @EventSourcingHandler
    public void on(ProductCreateEvent productCreateEvent)
    {
        this.productId=productCreateEvent.getProductId();
        this.productName=productCreateEvent.getProductName();
        this.productPriceTag=productCreateEvent.getProductPriceTag();
        this.productQuantity=productCreateEvent.getProductQuantity();

    }
}
