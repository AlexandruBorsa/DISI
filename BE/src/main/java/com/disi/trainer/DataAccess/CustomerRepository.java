package com.disi.trainer.DataAccess;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findByTrainerId(Integer trainerId);
    Optional<Customer> findByIdAndTrainerId(Integer customerId, Integer trainerId);
}
