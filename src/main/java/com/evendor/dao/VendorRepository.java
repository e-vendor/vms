package com.evendor.dao;

import com.evendor.model.Vendor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "vendors", collectionResourceRel = "vendors")
public interface VendorRepository extends PagingAndSortingRepository<Vendor, Long>{

}