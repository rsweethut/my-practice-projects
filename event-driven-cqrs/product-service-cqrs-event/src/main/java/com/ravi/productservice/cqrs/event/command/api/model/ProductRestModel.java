package com.ravi.productservice.cqrs.event.command.api.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductRestModel {

    private String productName;
    private BigDecimal productPriceTag;
    private Integer productQuantity;
}
