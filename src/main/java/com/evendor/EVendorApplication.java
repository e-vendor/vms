package com.evendor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.evendor.dao.VendorRepository;

@SpringBootApplication
public class EVendorApplication {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	VendorRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(EVendorApplication.class, args);
	}
}
