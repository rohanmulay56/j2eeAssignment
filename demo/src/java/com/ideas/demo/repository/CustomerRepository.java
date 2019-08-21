package com.ideas.ngi.ahws.common.controller;

import com.ideas.ngi.ahws.common.admin.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public class CustomerRepository extends JpaRepository<Customer, Long>{
    public Customer findById(int id);
    public Customer findByName(String name);
    public long deleteByName(String name);
}
