package com.ravi.productservice.cqrs.event.command.api.commands;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;

import java.math.BigDecimal;

@Data
@Builder
public class CreateProductCommand {

    @TargetAggregateIdentifier
    private String productId;
    private String productName;
    private BigDecimal productPriceTag;
    private Integer productQuantity;
}
