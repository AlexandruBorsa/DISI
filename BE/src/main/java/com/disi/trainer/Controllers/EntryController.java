package com.disi.trainer.Controllers;

import com.disi.trainer.BusinessLogic.CustomerService;
import com.disi.trainer.BusinessLogic.EntryService;
import com.disi.trainer.DataAccess.Customer;
import com.disi.trainer.DataAccess.Entry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EntryController {

    @Autowired
    private EntryService entryService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(method = RequestMethod.GET, value = "/customers/{id}/entries")
    public List<Entry> getAllEntriesByCustomerId (@PathVariable Integer id){
        return entryService.findByCustomerId(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/customers/{customerId}/entries/{entryId}")
    public Optional<Entry> getEntryByIdAndCustomerId(@PathVariable Integer customerId, @PathVariable Integer entryId){
        return entryService.findByIdAndCustomerId(entryId, customerId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/customers/{customerId}/entries")
    public ResponseEntity<Entry> addEntry(@PathVariable Integer customerId, @RequestBody Entry entry){

        Optional<Customer> customer =  customerService.getCustomerById(customerId);

        if(customer==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            entry.setCustomer(customer.get());
            entryService.addEntry(entry);
            return new ResponseEntity<>(entry, HttpStatus.OK);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/customers/{customerId}/entries/{entryId}")
    public ResponseEntity<?> deleteEntry(@PathVariable Integer customerId, @PathVariable Integer entryId){

        Optional<Entry> entry = entryService.findByIdAndCustomerId(entryId, customerId);

        if(entry==null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            entryService.deleteEntry(entry.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/customers/{customerId}/entries")
    public ResponseEntity<Entry> updateEntry(@PathVariable Integer customerId, @RequestBody Entry entry){

        Optional<Customer> customer =  customerService.getCustomerById(customerId);

        if(!customerService.existsById(customerId)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            entry.setCustomer(customer.get());
            entryService.updateEntry(entry);

            return new ResponseEntity<>(entry, HttpStatus.OK);
        }
    }


}
