package com.disi.trainer.DataAccess;

import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    Customer findCustomerByName(String name);
    ArrayList<Customer> findAll();
}
