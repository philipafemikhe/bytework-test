package com.servbyte.app.repositories;

import com.servbyte.app.entities.FoodProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodProviderRepository extends JpaRepository<FoodProvider, Long> {
}
