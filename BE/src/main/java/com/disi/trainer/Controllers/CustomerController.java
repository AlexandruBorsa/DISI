package com.disi.trainer.Controllers;

import com.disi.trainer.BusinessLogic.CustomerService;
import com.disi.trainer.DataAccess.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/customers")
    public List<Customer> getAllCustomers (){

        return customerService.getAllCustomers();
    }

    @RequestMapping("/customer/{id}")
    public Optional<Customer> getCustomerById(@PathVariable String id){
        return customerService.getCustomerById(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers")
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){

        customerService.addCustomer(customer);

        return new ResponseEntity<>(customer, HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{id}")
    public ResponseEntity<?> deleteCustomer(@PathVariable String id){

        customerService.deleteCustomer(Integer.parseInt(id));

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer){

        customerService.updateCustomer(customer);

        return new ResponseEntity<>(customer, HttpStatus.OK);
    }


}
