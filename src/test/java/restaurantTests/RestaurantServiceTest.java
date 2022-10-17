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
import java.util.Optional;

import static org.mockito.Mockito.doReturn;
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
    void should_get_restaurant_from_address() {
        Restaurant testRestaurant = new Restaurant("Test Burger", "American", "42 Wallaby Way, Sydney");
        doReturn(testRestaurant).when(repository).findByAddress("42 Wallaby Way, Sydney");

        Restaurant returned = repository.findByAddress("42 Wallaby Way, Sydney");

        Assertions.assertEquals("42 Wallaby Way, Sydney", returned.getAddress());
    }

    @Test
    void should_not_find_restaurant_if_address_not_found() {
        Restaurant returned = repository.findByAddress("42 Wallaby Way, Sydney");

        Assertions.assertEquals(returned, null);
    }

    @Test
    void should_modify_restaurant_values() {

    }

    @Test
    void deleteRestaurant() {
    }
}