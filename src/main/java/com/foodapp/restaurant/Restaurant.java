package com.foodapp.restaurant;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "restaurants")
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String cuisine;
    private String address;
    private int rating;
    private List<String> opening_hours;
    private String url;
    private List<Object> reviews;
    private String business_status;

    public Restaurant(String name, String cuisine, String address, int rating, List<String> opening_hours, String url, List<Object> reviews, String business_status) {
        this.name = name;
        this.cuisine = cuisine;
        this.address = address;
        this.rating = rating;
        this.opening_hours = opening_hours;
        this.url = url;
        this.reviews = reviews;
        this.business_status = business_status;
    }
}
