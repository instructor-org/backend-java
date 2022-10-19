package restaurantTests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.foodapp.restaurant.RestaurantService;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@AutoConfigureMockMvc
class RestaurantControllerTest {


    private MockMvc mockMvc;
    @MockBean
    private RestaurantService restaurantService;
    @Autowired
    private WebApplicationContext wac;
    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }
    @Test
    public void test_get_all_restaurants() throws Exception {
//        Restaurant testaurantOne = new Restaurant("test one", "testy", "testy street");
//        Restaurant testaurantTwo = new Restaurant("test two", "testyy", "testy streets");
//
//        doReturn(Lists.newArrayList(testaurantOne, testaurantTwo)).when(restaurantService).getAll();

        mockMvc.perform(get("/restaurant")
                .contentType(MediaType.APPLICATION_JSON));
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
//                .andExpect(header().string(HttpHeaders.LOCATION, "/restaurant")));
//                .andExpect(jsonPath("$", hasSize(2)))
//                .andExpect(jsonPath("$[0].name", is("test one")))
//                .andExpect(jsonPath("$[0].cuisine", is("testy")))
//                .andExpect(jsonPath("$[0].address", is("testy street")))
//                .andExpect(jsonPath("$[1].name", is("test two")))
//                .andExpect(jsonPath("$[1].cuisine", is("testyy")))
//                .andExpect(jsonPath("$[1].address", is("testy streets")));

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