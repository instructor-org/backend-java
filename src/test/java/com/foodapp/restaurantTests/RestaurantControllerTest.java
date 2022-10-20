package restaurantTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RestController;
import com.foodapp.restaurant.RestaurantService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest()
class RestaurantControllerTest {

    @Autowired
    private MockMvc mockMvc;
//    @MockBean
//    private RestaurantService restaurantService;
    @Test
    public void test_get_all_restaurants() throws Exception {
        this.mockMvc.perform(get("/food/restaurant"))
                .andExpect(status().isOk());

    }
    @Test
    void saveRestaurant() {
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