package com.servbyte.app.controllers;

import com.servbyte.app.entities.Customer;
import com.servbyte.app.entities.FoodProvider;
import com.servbyte.app.entities.Meal;
import com.servbyte.app.services.CustomerService;
import com.servbyte.app.services.FoodVendorService;
import com.servbyte.app.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private FoodVendorService foodVendorService;

    @Autowired
    private MealService mealService;

    @PostMapping("/customer/create")
    public Customer createCustomer(@RequestBody Customer customer){
        return this.customerService.create(customer);
    }

    @GetMapping("service/providers")
    public List<FoodProvider> allVendors(){
        return this.foodVendorService.getAll();
    }

    @GetMapping("/restaurant/{id}")
    public List<Meal> getRestaurant(@PathVariable Long id){
        return this.mealService.getVendorMeals(id);
    }

    @GetMapping("/meal/{id}")
    public Meal getMealDetails(@PathVariable Long id){
        return this.mealService.getOne(id);
    }
}
