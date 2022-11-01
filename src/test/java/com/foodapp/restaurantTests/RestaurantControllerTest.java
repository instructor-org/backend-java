package com.foodapp.restaurantTests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.foodapp.restaurant.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.foodapp.restaurant.RestaurantService;
import java.util.Arrays;

import static org.mockito.Mockito.doReturn;
import static org.springframework.data.mongodb.util.BsonUtils.toJson;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@AutoConfigureMockMvc
@SpringBootTest()
class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private RestaurantService restaurantService;


    @Test
    void test_get_all_restaurants() throws Exception {
        this.mockMvc.perform(get("/food/restaurant")
                .contentType("application/json"))
                .andExpect(status().isOk());

    }
    @Test
    void test_save_Restaurant() throws Exception {
        Restaurant testaurant = new Restaurant("Hubert's Eggs", "Hawaiian", "46 Wallaby Way, Sydney", 5, Arrays.asList("Opening hours"), "url", Arrays.asList("reviews"), "Open");
        this.mockMvc.perform(post("/food/restaurant")
                        .content(asJson(testaurant))
                        .contentType("application/json"))
                        .andExpect(status().isOk());
    }
    @Test
    void whenValidInput_returnsStatus200() throws Exception {
    }


    @Test
    void get_Restaurant_By_Cuisine() throws Exception {
        Restaurant testaurant = new Restaurant("Hubert's Eggs", "Hawaiian", "46 Wallaby Way, Sydney", 5, Arrays.asList("Opening hours"), "url", Arrays.asList("reviews"), "Open");

        this.mockMvc.perform(get("/food/restaurant/cuisine/{cuisine}", "Hawaiian")
                    .contentType("application/json")).andExpect(status().isOk());
        doReturn(Arrays.asList(testaurant)).when(this.restaurantService).getRestaurantByCuisine("Hawaiian");
    }

    @Test
    void modifyRestaurant() throws Exception {
        Restaurant testaurant = new Restaurant("Test", "test", "test", 5,Arrays.asList("Opening-Hours"), "test", Arrays.asList("Reviews"), "test");
        Restaurant testaurantUpdate = new Restaurant("Cheese", "test", "test", 5,Arrays.asList("Opening-Hours"), "test", Arrays.asList("Reviews"), "test");
        testaurant.setId("1");
        this.mockMvc.perform(post("/food/restaurant")
                        .content(asJson(testaurant))
                        .contentType("application/json"))
                .andExpect(status().isOk());

        this.mockMvc.perform(put("/food/restaurant/" + testaurant.getId())
                .contentType(MediaType.APPLICATION_JSON).content(asJson(testaurantUpdate)))
                .andExpect(status().isAccepted());
    }

    @Test
    void deleteRestaurant() {
    }

    public static String asJson(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}