package restaurantTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import restaurant.Restaurant;
import restaurant.RestaurantRepository;
import restaurant.RestaurantService;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.doReturn;
import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class RestaurantServiceTest {

    @InjectMocks
    private RestaurantService restaurantService;
    @Mock
    private RestaurantRepository repository;

    @Test
    @DisplayName("Test getAll")
    void should_get_all_restaurants() {
        Restaurant firstRestaurant = new Restaurant("Doutor", "Cafe", "12, A Street");
        Restaurant secondRestaurant = new Restaurant("Kajiken", "Japanese", "11, A Street");
        doReturn(Arrays.asList(firstRestaurant, secondRestaurant)).when(repository).findAll();

        List<Restaurant> restaurants = restaurantService.getAll();

        Assertions.assertEquals(2, restaurants.size());
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