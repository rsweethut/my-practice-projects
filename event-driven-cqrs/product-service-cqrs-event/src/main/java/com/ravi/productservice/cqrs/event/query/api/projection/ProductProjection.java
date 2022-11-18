package com.ravi.productservice.cqrs.event.query.api.projection;

import com.ravi.productservice.cqrs.event.command.api.aggregate.ProductAggregate;
import com.ravi.productservice.cqrs.event.command.api.data.Product;
import com.ravi.productservice.cqrs.event.command.api.data.ProductRepository;
import com.ravi.productservice.cqrs.event.command.api.model.ProductRestModel;
import com.ravi.productservice.cqrs.event.query.api.queries.GetProductsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductProjection {

    ProductRepository productRepository;

    public ProductProjection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @QueryHandler
    public List<ProductRestModel> handle(GetProductsQuery getProductsQuery)
    {
        List<Product> products =
                productRepository.findAll();

        List<ProductRestModel> productRestModel =
                products.stream().map(product -> ProductRestModel.builder()
                        .productName(product.getProductName())
                        .productQuantity(product.getProductQuantity())
                        .productPriceTag(product.getProductPriceTag())
                        .build()).collect(Collectors.toList());
        return productRestModel;
    }
}
