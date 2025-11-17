package org.enset.billingservice.web;

import jakarta.ws.rs.Path;
import lombok.AllArgsConstructor;
import org.enset.billingservice.entities.Bill;
import org.enset.billingservice.feign.CustomerServiceRestClient;
import org.enset.billingservice.feign.InverntoryServiceRestClient;
import org.enset.billingservice.model.Customer;
import org.enset.billingservice.repositories.BillRepository;
import org.enset.billingservice.repositories.ProductItemRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class BillRestController {

    private  BillRepository billRepository;
    private ProductItemRepository productItemRepository;

    private CustomerServiceRestClient customerServiceRestClient;
    private InverntoryServiceRestClient inverntoryServiceRestClient;

    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable Long id) {

        Bill bill = billRepository.findById(id).get();
        Customer customer = customerServiceRestClient.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);
        bill.getProductItems().forEach(pi -> {
            pi.setProduct(inverntoryServiceRestClient.getProduct(pi.getProductId()));
        });
        return bill;
    }
}
