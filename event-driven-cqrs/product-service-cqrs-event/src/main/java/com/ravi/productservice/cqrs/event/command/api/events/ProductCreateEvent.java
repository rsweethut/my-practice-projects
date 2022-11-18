package com.ravi.productservice.cqrs.event.command.api.events;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductCreateEvent {

    private String productId;
    private String productName;
    private BigDecimal productPriceTag;
    private Integer productQuantity;

}
