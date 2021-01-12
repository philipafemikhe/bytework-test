package com.servbyte.app.services;

import com.servbyte.app.entities.FoodProvider;
import com.servbyte.app.entities.Meal;
import com.servbyte.app.repositories.FoodProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FoodVendorService {
    @Autowired
    private FoodProviderRepository foodProviderRepository;

    public FoodProvider createVendor(FoodProvider foodProvider) {
        return this.foodProviderRepository.save(foodProvider);
    }

    public List<FoodProvider> getAll() {
        return this.foodProviderRepository.findAll();
    }

    public FoodProvider getOne(Long id) {
        FoodProvider foodProvider = this.foodProviderRepository.getOne(id);
        return foodProvider;
    }
}
