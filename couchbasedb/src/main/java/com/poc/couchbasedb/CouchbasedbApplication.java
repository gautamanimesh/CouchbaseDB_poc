package com.poc.couchbasedb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = {"com.poc.couchbasedb.*"})
public class CouchbasedbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CouchbasedbApplication.class, args);
	}
}
