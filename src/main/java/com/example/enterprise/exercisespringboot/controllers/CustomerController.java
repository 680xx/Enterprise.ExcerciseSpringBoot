package com.example.enterprise.exercisespringboot.controllers;

import com.example.enterprise.exercisespringboot.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CustomerController {

    List<Customer> customerList = new ArrayList<>(List.of(
            new Customer(1, "Bengt", "Bedrup", "bengan@bedde.com"),
            new Customer(2, "Lars", "Trasan", "mittidjungeln@skogen.se"),
            new Customer(3, "Goran", "Ivanisevic", "tennis@hallen.com")
    ));


    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    @ResponseBody
    public List<Customer> getCustomers() {
        return customerList;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Customer getCustomerById(@PathVariable("id") int id) {
        StreamingController streamingController = new StreamingController();
        customerList.get(0).setStreamingService(streamingController.returnService(0));
        customerList.get(1).setStreamingService(streamingController.returnService(1));
        customerList.get(2).setStreamingService(streamingController.returnService(2));
        for (Customer customer: customerList) {
            if (customer.getId() == id) {
                return customer;
            }

        }
        return null;
    }

}
