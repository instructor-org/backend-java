package restaurantTests;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import restaurant.RestaurantController;
import restaurant.RestaurantService;

import static org.junit.jupiter.api.Assertions.*;

class RestaurantControllerTest {
    @InjectMocks
    RestaurantController restaurantController;
    @Mock
    RestaurantService restaurantService;
    @Test
    void saveRestaurant() {
    }

    @Test
    void getAllRestaurants() {
    }

    @Test
    void getRestaurantById() {
    }

    @Test
    void modifyRestaurant() {
    }

    @Test
    void deleteRestaurant() {
    }
}