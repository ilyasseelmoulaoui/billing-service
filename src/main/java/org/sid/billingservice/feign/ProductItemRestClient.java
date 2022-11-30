package org.sid.billingservice.feign;

import org.sid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@FeignClient(name = "PRODUCT-SERVICE")         //Pour pouvoir communiquer avec les autres micro-services
public interface ProductItemRestClient {
    @GetMapping(path = "/products")
    PagedModel<Product> pageProducts(@RequestParam(value = "page", defaultValue = "0") int page,
                                     @RequestParam(value = "size" ,defaultValue = "7") int size);

    @GetMapping(path = "/products/{id}")
    Product getProductById(@PathVariable Long id);
}
