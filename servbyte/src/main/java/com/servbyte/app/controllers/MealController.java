package com.servbyte.app.controllers;

import com.servbyte.app.entities.Meal;
import com.servbyte.app.services.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MealController {

    @Autowired
    private MealService mealService;

    @GetMapping("meals")
    public List<Meal> allMeals(){
        return this.mealService.getMealList();
    }
}
