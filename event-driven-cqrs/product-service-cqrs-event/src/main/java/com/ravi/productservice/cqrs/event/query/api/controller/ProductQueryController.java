package com.ravi.productservice.cqrs.event.query.api.controller;

import com.ravi.productservice.cqrs.event.command.api.data.Product;
import com.ravi.productservice.cqrs.event.command.api.model.ProductRestModel;
import com.ravi.productservice.cqrs.event.query.api.queries.GetProductsQuery;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductQueryController {

    QueryGateway queryGateway;

    public ProductQueryController(QueryGateway queryGateway) {
        this.queryGateway = queryGateway;
    }

    @GetMapping
    public List<ProductRestModel> getAllProducts()
    {
        GetProductsQuery getProductsQuery = new GetProductsQuery();
        List<ProductRestModel> productRestModel =
        queryGateway.query(getProductsQuery, ResponseTypes.multipleInstancesOf(ProductRestModel.class)).join();
        return productRestModel;
    }
}
