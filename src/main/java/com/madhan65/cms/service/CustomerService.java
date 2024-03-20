package com.madhan65.cms.service;
import com.madhan65.cms.entity.Customer;
import com.madhan65.cms.exception.CustomerNotFoundException;
import com.madhan65.cms.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new CustomerNotFoundException("customer not found")
        );
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    public Customer updateCustomer(Customer customer, Long id) {
        Customer c = customerRepository.findById(id).get();
        if(Objects.nonNull(customer.getFirstName()) &&
                !"".equalsIgnoreCase(customer.getFirstName())){
            c.setFirstName(customer.getFirstName());
        }
        if(Objects.nonNull(customer.getLastName()) &&
                !"".equalsIgnoreCase(customer.getLastName())){
            c.setLastName(customer.getLastName());
        }
        if(Objects.nonNull(customer.getEmail()) &&
                !"".equalsIgnoreCase(customer.getEmail())){
            c.setEmail(customer.getEmail());
        }
        if(Objects.nonNull(customer.getMobile()) &&
                !"".equalsIgnoreCase(customer.getMobile())){
            c.setMobile(customer.getMobile());
        }
        if(Objects.nonNull(customer.getCountry()) &&
                !"".equalsIgnoreCase(customer.getCountry())){
            c.setCountry(customer.getCountry());
        }
        if(Objects.nonNull(customer.getCity()) &&
                !"".equalsIgnoreCase(customer.getCity())){
            c.setCity(customer.getCity());
        }
        if(Objects.nonNull(customer.getAddress()) &&
                !"".equalsIgnoreCase(customer.getAddress())){
            c.setAddress(customer.getAddress());
        }
        return customerRepository.save(c);
    }
}
