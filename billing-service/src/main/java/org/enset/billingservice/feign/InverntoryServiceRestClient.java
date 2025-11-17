package org.enset.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.enset.billingservice.model.Customer;
import org.enset.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface InverntoryServiceRestClient {
    @GetMapping("/products/{id}")
    @CircuitBreaker(name = "inventoryService", fallbackMethod = "getDefaultProduct")
    Product getProduct(@PathVariable Long id);



    default  Product getDefaultProduct(Long id, Exception exception) {
        exception.printStackTrace();
        Product product = new Product();
        product.setId(id);
        product.setName("Default product");
        product.setPrice(100.0);
        product.setQuantity(10);
        return product;
    }
}
