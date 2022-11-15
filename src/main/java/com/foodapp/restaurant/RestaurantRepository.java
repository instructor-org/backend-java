package com.foodapp.restaurant;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    Restaurant findByAddress(String address);
    List<Restaurant> findByCuisine(String cuisine);
}
