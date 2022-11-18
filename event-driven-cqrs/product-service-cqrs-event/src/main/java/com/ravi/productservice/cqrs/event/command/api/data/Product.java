package com.ravi.productservice.cqrs.event.command.api.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
public class Product {

    @Id
    private String productId;
    private String productName;
    private BigDecimal productPriceTag;
    private Integer productQuantity;
}
