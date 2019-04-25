package com.disi.trainer.Controllers;

import com.disi.trainer.BusinessLogic.CustomerService;
import com.disi.trainer.DataAccess.Customer;
import org.springframework.beans.factory.annotation.Autowired;
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
    public void addCustomer(@RequestBody Customer customer){
        customerService.addCustomer(customer);
    }

}
