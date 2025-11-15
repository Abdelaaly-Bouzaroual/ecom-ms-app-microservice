package org.masterenset.inventoryservice;

import org.masterenset.inventoryservice.entities.products;
import org.masterenset.inventoryservice.repository.ProductsRespository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductsRespository productsRepository) {
        return args -> {
            productsRepository.save(products.builder().name("phone").price(100).quantity(12).build());
            productsRepository.save(products.builder().name("home").price(99).quantity(10).build());
            productsRepository.save(products.builder().name("Pizza").price(45).quantity(30).build());
            productsRepository.save(products.builder().name("headphone").price(9961).quantity(50).build());
            productsRepository.save(products.builder().name("screen").price(1433).quantity(58).build());
            productsRepository.save(products.builder().name("smart whatch").price(362).quantity(74).build());
            productsRepository.save(products.builder().name("laptop").price(225).quantity(63).build());
        };
    }
}
