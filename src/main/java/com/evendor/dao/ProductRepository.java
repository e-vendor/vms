package com.evendor.dao;

import com.evendor.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "products", collectionResourceRel = "products")
public interface ProductRepository extends PagingAndSortingRepository<Product, Long>{

}