package com.disi.trainer.BusinessLogic;

import com.disi.trainer.DataAccess.Customer;
import com.disi.trainer.DataAccess.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {

        List<Customer> customers = new ArrayList<>();

        customerRepository.findAll()
                .forEach(customers::add);

        return customers;
    }

    public List<Customer> findByTrainerId(Integer id) {
        List<Customer> customers = new ArrayList<>();
        customerRepository.findByTrainerId(id).forEach(customers::add);
        return customers;
    }

    public Optional<Customer> findByIdAndTrainerId(Integer customerId, Integer trainerId) {
        return customerRepository.findByIdAndTrainerId(customerId, trainerId);
    }

    public Optional<Customer> getCustomerById (Integer id){
        return customerRepository.findById(id);
    }

    public void addCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public void deleteCustomer(Customer customer){
        customerRepository.delete(customer);
    }

    public void updateCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Boolean existsById(Integer id){
        return customerRepository.existsById(id);
    }

}
