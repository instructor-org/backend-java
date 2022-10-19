package com.foodapp;

import com.foodapp.restaurant.Restaurant;
import com.foodapp.restaurant.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;


@SpringBootApplication
public class FoodappApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodappApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(RestaurantRepository repo) {
		return args -> {
			Restaurant restaurant = new Restaurant("joe", "monroe","joemon@joe", 1,  Arrays.asList("opening_hours"), "hello",Arrays.asList("reviews"), "closed");
				repo.insert(restaurant);
		};
	}

}
