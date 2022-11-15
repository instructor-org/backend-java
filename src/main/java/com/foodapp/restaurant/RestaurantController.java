package com.foodapp.restaurant;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/food")
public class RestaurantController {

    final RestaurantService restaurantService;

    private final RestaurantRepository repository;

    public RestaurantController(RestaurantService restaurantService, RestaurantRepository repository)  {
        this.restaurantService = restaurantService;
        this.repository = repository;
    }

    @PostMapping("/restaurant")
    @ResponseStatus(HttpStatus.CREATED)
    public String saveRestaurant(@RequestBody Restaurant restaurant) {
        repository.save(restaurant);
        return "Restaurant created successfully!";
    }

    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAllRestaurants();
    }

    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable String id, HttpServletResponse res) {
        Optional<Restaurant> restaurant = restaurantService.getRestaurantById(id);
        if (restaurant.isEmpty()) {
            res.setStatus(404);
        } else {
            res.setStatus(200);
        }
        return restaurantService.getRestaurantById(id);
    }
    @GetMapping("/restaurant/cuisine/{cuisine}")
    public List<Restaurant> getRestaurantsByCuisine(@PathVariable String cuisine) {
        return restaurantService.getRestaurantByCuisine(cuisine);
    }

    @PutMapping("/restaurant/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Optional<Restaurant> modifyRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable String id, HttpServletResponse res) {
        Optional<Restaurant> restaurant = restaurantService.modifyRestaurant(newRestaurant, id);
        if (restaurant.isEmpty()) {
            res.setStatus(404);
        } else {
            res.setStatus(202);
        }
        return restaurant;
    }

    @DeleteMapping("/restaurant/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteRestaurant(@PathVariable String id) {
        restaurantService.deleteRestaurant(id);
    }
}
