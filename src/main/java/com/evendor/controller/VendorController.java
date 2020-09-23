package com.evendor.controller;

import java.net.URI;
import java.util.Optional;

import com.evendor.error.VendorNotFoundException;
import com.evendor.model.Vendor;
import com.evendor.dao.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class VendorController {

	@Autowired
	private VendorRepository vendorRepository;

	@GetMapping("/vendors")
	public Iterable<Vendor> retrieveAllVendors() {
		return vendorRepository.findAll();
	}

	@GetMapping("/vendors/{id}")
	public Vendor retrieveVendor(@PathVariable long id) {
		Optional<Vendor> vendor = vendorRepository.findById(id);
		if (!vendor.isPresent()) {
			throw new VendorNotFoundException("id-" + id);
		}
		return vendor.get();
	}

	@DeleteMapping("/vendors/{id}")
	public void deleteVendor(@PathVariable long id) {
		Optional<Vendor> vendorOptional = vendorRepository.findById(id);
		if (!vendorOptional.isPresent()) {
			throw new VendorNotFoundException("id-" + id);
		}
		vendorRepository.deleteById(id);
	}

	@PostMapping("/vendors")
	public ResponseEntity<Object> createVendor(@RequestBody Vendor vendor) {
		Vendor savedVendor = vendorRepository.save(vendor);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedVendor.getId()).toUri();
		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/vendors/{id}")
	public ResponseEntity<Object> updateVendor(@RequestBody Vendor vendor, @PathVariable long id) {
		Optional<Vendor> vendorOptional = vendorRepository.findById(id);
		if (!vendorOptional.isPresent()) {
			throw new VendorNotFoundException("id-" + id);
		}

		vendor.setId(id);
		vendorRepository.save(vendor);
		return ResponseEntity.noContent().build();
	}
}