package com.servbyte.app.services;

import com.servbyte.app.entities.Meal;
import com.servbyte.app.repositories.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MealService {
    @Autowired
    private MealRepository mealRepository;

    public Meal createMeal(Meal meal){
        return this.mealRepository.save(meal);
    }

    public List<Meal> getMealList() {
        return this.mealRepository.findAll();
    }

    public List<Meal> getVendorMeals(Long id) {
        return this.mealRepository.findByProviderId(id);
    }

    public Meal getOne(Long id) {
        return this.mealRepository.getOne(id);
    }
}
