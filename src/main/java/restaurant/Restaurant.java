package restaurant;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String cuisine;
    private String address;

    public Restaurant(String name, String cuisine, String address) {
        this.name = name;
        this.cuisine = cuisine;
        this.address = address;
    }
}
