package restaurant;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {

    final RestaurantService restaurantService;

    private final RestaurantRepository repository;

    public RestaurantController(RestaurantService restaurantService, RestaurantRepository repository)  {
        this.restaurantService = restaurantService;
        this.repository = repository;
    }


    @PostMapping("/restaurant")
    public String saveRestaurant(@RequestBody Restaurant restaurant) {
        repository.save(restaurant);
        return "Restaurant created successfully!";
    }

    @GetMapping("/restaurant")
    public List<Restaurant> getAllRestaurants() {
        return restaurantService.getAll();
    }

    @GetMapping("/restaurant/{id}")
    public Optional<Restaurant> getRestaurantById(@PathVariable String id) {
        return restaurantService.getRestaurantById(id);
    }

    @PutMapping("/restaurant/{id}")
    public Optional<Restaurant> modifyRestaurant(@RequestBody Restaurant newRestaurant, @PathVariable String id) {
        return restaurantService.modifyRestaurant(newRestaurant, id);
    }

    @DeleteMapping("/restaurant/{id}")
    public void deleteRestaurant(@PathVariable String id) {
        restaurantService.deleteRestaurant(id);
    }
}
