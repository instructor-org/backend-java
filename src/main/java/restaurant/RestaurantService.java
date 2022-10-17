package restaurant;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepository repository;

    public RestaurantService(RestaurantRepository repository) {
        this.repository = repository;
    }

    public List<Restaurant> getAll() {
        return repository.findAll();
    }

    public Optional<Restaurant> getRestaurantById(String id) {
        return repository.findById(id);
    }

    public Optional<Restaurant> modifyRestaurant(Restaurant newRestaurant, String id) {
        return repository.findById(id).map(restaurant -> {
            restaurant.setName(newRestaurant.getName());
            restaurant.setCuisine(newRestaurant.getCuisine());
            restaurant.setAddress(newRestaurant.getAddress());
            return repository.save(restaurant);
        });
    }

    public void deleteRestaurant(String id) {
        repository.deleteById(id);
    }

}
