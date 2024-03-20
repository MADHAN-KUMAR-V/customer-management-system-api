package com.madhan65.cms.controller;

import com.madhan65.cms.entity.Customer;
import com.madhan65.cms.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getCustomers(){
        List<Customer> allcustomer = customerService.getCustomers();
        return new ResponseEntity<>(allcustomer, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomer(@PathVariable("id") Long id ){
        Customer customer = customerService.getCustomer(id);
        return new ResponseEntity<>(customer,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
        Customer thecustomer = customerService.addCustomer(customer);
        return new ResponseEntity<>(thecustomer,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer ,@PathVariable("id") Long id){
        Customer thecustomer = customerService.updateCustomer(customer,id);
        return new ResponseEntity<>(thecustomer,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public void deleteCustomer(@PathVariable("id") Long id){
        customerService.deleteCustomer(id);
    }
}
