package com.poc.couchbasedb.repository;

import com.poc.couchbasedb.model.Customer;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CouchbaseRepository<Customer, Integer> {

}
