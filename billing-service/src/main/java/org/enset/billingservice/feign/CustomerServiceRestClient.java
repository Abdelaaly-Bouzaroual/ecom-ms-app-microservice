package org.enset.billingservice.feign;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.Data;
import org.enset.billingservice.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerServiceRestClient {
    @GetMapping("/customers/{id}")
    @CircuitBreaker(name = "customerService", fallbackMethod = "getDefaultCustomer")
    Customer findCustomerById(@PathVariable Long id);

    default  Customer getDefaultCustomer(Long id, Exception exception) {
        exception.printStackTrace();
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName("Default Customer");
        customer.setEmail("default@gmail.com");
        return customer;
    }
}
