package org.masterenset.inventoryservice.repository;

import org.masterenset.inventoryservice.entities.products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "products", collectionResourceRel = "products")
public interface ProductsRespository extends JpaRepository<products, Long> {
}
