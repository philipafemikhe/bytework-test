package com.servbyte.app.controllers;

import com.servbyte.app.entities.Customer;
import com.servbyte.app.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WelcomeController {

    @Autowired
    CustomerService customerService;




    @GetMapping("/")
    public ArrayList<String> welcome(){
        ArrayList ourServices = new ArrayList<String>();
        ourServices.add("Food");
        ourServices.add("Laundry");
        ourServices.add("Pharmacy ");
        ourServices.add("Grocery");
        return ourServices;
//        return new JSONObject(ourServices) ;
    }

    @GetMapping("/customer")
    public List<Customer> customers(){
        return this.customerService.getAll();
    }
}
