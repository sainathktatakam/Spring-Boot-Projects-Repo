package com.javatechie.springdatajpademo.controller;

import java.util.ArrayList;
import java.util.List;

import com.javatechie.springdatajpademo.dto.OrderRequest;
import com.javatechie.springdatajpademo.entity.Customer;
import com.javatechie.springdatajpademo.entity.Product;
import com.javatechie.springdatajpademo.repository.CustomerRepository;
import com.javatechie.springdatajpademo.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/placeOrder")
    public Customer placeOrder(@RequestBody OrderRequest request){
       return  customerRepository.save( request.getCustomer());
    }

    @GetMapping("/findAllOrders")
    public List<Product> findAllOrders(){
            List<Product> li = new ArrayList<Product>();
            Product p = new Product();
                p.setPid(999);
                p.setPrice(250);
                p.setProductName("I-Phone");
                p.setQty(10);
                li.add(p);
                li.add(p);
            return li;
        //return productRepository.findAll();
    }
    
}
