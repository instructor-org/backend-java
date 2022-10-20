package com.foodapp.restaurantTests;

import com.foodapp.restaurant.Restaurant;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.foodapp.restaurant.RestaurantService;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.web.servlet.function.RequestPredicates.contentType;

@AutoConfigureMockMvc
@SpringBootTest()
class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RestaurantService restaurantService;
    @Test
    public void test_get_all_restaurants() throws Exception {
        this.mockMvc.perform(get("/food/restaurant"))
                .andExpect(status().isOk());

    }
    @Test
    void saveRestaurant() {
    }
    @Test
    void whenValidInput_returnsStatus200() throws Exception {
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