package com.foodapp.restaurantTests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.foodapp.restaurant.Restaurant;
import com.foodapp.restaurant.RestaurantRepository;
import com.foodapp.restaurant.RestaurantService;
import java.util.Arrays;
import java.util.List;

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
        Restaurant firstRestaurant = new Restaurant("Doutor", "Cafe", "12, A Street", 4,Arrays.asList("opening"), "url", Arrays.asList("reviews"), "Open");
        Restaurant secondRestaurant = new Restaurant("Kajiken", "Japanese", "11, A Street", 5, Arrays.asList("opening"), "url", Arrays.asList("reviews"), "Closed");
        doReturn(Arrays.asList(firstRestaurant, secondRestaurant)).when(repository).findAll();

        List<Restaurant> restaurants = restaurantService.getAllRestaurants();

        Assertions.assertEquals(2, restaurants.size());
    }

    @Test
    @DisplayName("Test findByAddress")
    void should_get_restaurant_from_address() {
        Restaurant testRestaurant = new Restaurant("Test Burger", "American", "42 Wallaby Way, Sydney", 1, Arrays.asList("com"), "url", Arrays.asList("reviews"), "Open");
        doReturn(testRestaurant).when(repository).findByAddress("42 Wallaby Way, Sydney");

        Restaurant returned = repository.findByAddress("42 Wallaby Way, Sydney");

        Assertions.assertEquals("42 Wallaby Way, Sydney", returned.getAddress());
    }

    @Test
    @DisplayName("Test address not found")
    void should_not_find_restaurant_if_address_not_found() {
        Restaurant returned = repository.findByAddress("42 Wallaby Way, Sydney");

        Assertions.assertEquals(returned, null);
    }

    @Test
    @DisplayName("Test modifyRestaurant")
    void should_modify_restaurant_values() {
    }

    @Test
    void deleteRestaurant() {
    }
}