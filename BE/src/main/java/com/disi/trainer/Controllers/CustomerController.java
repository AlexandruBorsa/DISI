package com.disi.trainer.Controllers;

import com.disi.trainer.BusinessLogic.CustomerService;
import com.disi.trainer.BusinessLogic.TrainerService;
import com.disi.trainer.DataAccess.Customer;
import com.disi.trainer.DataAccess.Trainer;
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

    @Autowired
    private TrainerService trainerService;

    @RequestMapping(method = RequestMethod.GET, value = "/trainers/{id}/customers")
    public List<Customer> getAllCustomersByTrainerId (@PathVariable String id){
        return customerService.findByTrainerId(Integer.parseInt(id));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/trainers/{trainerId}/customers/{customerId}")
    public Optional<Customer> getCustomerByIdAndTrainerId(@PathVariable Integer trainerId, @PathVariable Integer customerId){
        return customerService.findByIdAndTrainerId(customerId, trainerId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/trainers/{trainerId}/customers")
    public ResponseEntity<Customer> addCustomer(@PathVariable Integer trainerId, @RequestBody Customer customer){

        Optional<Trainer> trainer =  trainerService.getTrainer(trainerId);

        if(trainer==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customer.setTrainer(trainer.get());
            customerService.addCustomer(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/trainers/{trainerId}/customers/{customerId}")
    public ResponseEntity<?> deleteCustomer(@PathVariable Integer trainerId, @PathVariable Integer customerId){

        Optional<Customer> customer = customerService.findByIdAndTrainerId(trainerId, customerId);

        if(customer==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customerService.deleteCustomer(customer.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/trainers/{trainerId}/customers")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer trainerId, @RequestBody Customer customer){

        Optional<Trainer> trainer =  trainerService.getTrainer(trainerId);

        if(!trainerService.existsById(trainerId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customer.setTrainer(trainer.get());
            customerService.updateCustomer(customer);

            return new ResponseEntity<>(customer, HttpStatus.OK);
        }
    }


}
