package com.servbyte.app.controllers;

import com.servbyte.app.entities.FoodProvider;
import com.servbyte.app.entities.Meal;
import com.servbyte.app.services.FoodVendorService;
import com.servbyte.app.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/vendor")
public class FoodProviderController {
    @Autowired
    private FoodVendorService foodVendorService;

    @Autowired
    private MealService mealService;


    @PostMapping("create")
    public FoodProvider createProvider(@RequestBody FoodProvider foodProvider){
        FoodProvider vendor = this.foodVendorService.createVendor(foodProvider);
        return vendor;
    }

    @PostMapping("meal/add/{id}")
    public Meal createMeal(@PathVariable Long id, @RequestBody Meal meal){

//        meal.setProvider(this.foodVendorService.getOne(id));
        return this.mealService.createMeal(meal);
    }

   @GetMapping("/all")
    public List<FoodProvider> allProviders(){
        return this.foodVendorService.getAll();
   }
}
