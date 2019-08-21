package com.ideas.ngi.ahws.common.admin;


import com.ideas.ngi.ahws.common.controller.CustomerRepository;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/customer", produces = MediaType.APPLICATION_JSON_VALUE)
public class CustomerController {
    private CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public Customer getCustomer(@RequestParam("name") String name) {
        return customerRepository.findByName(name);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.DELETE)
    public long deleteCustomer(@RequestParam("name") String name) {
        return customerRepository.deleteByName(name);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.POST)
    public Customer updateCustomer(@RequestParam("name") String name,@RequestParam("newName") String newName) {
        Customer customer= customerRepository.findByName(name);
        customer.setName(newName);
        return customerRepository.save(customer);
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public Customer saveCustomer(@RequestParam("name") String name) {
        Customer customer= new Customer();
        customer.setName(name);
        return customerRepository.save(customer);
    }
}
