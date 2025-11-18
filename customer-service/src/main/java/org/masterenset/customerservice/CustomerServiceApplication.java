package org.masterenset.customerservice;

import org.masterenset.customerservice.config.CustomerConfigParams;
import org.masterenset.customerservice.entities.Customer;
import org.masterenset.customerservice.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(CustomerConfigParams.class)
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        return args -> {
            customerRepository.save(Customer.builder().name("mohammed ").email("med@gmail.com").build());
            customerRepository.save(Customer.builder().name("samir").email("samir@gmail.com").build());
                customerRepository.save(Customer.builder().name("khalid").email("khalid@gmail.com").build());
            customerRepository.save(Customer.builder().name("farid").email("farid@gmail.com").build());
        };
    }
}
