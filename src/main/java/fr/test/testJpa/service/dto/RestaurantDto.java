package fr.test.testJpa.service.dto;

import fr.test.testJpa.model.Restaurant;
import org.springframework.util.Assert;

public class RestaurantDto {

    private Long id;
    private String name;

    public RestaurantDto(String name) {
        this.name = name;
    }

    public RestaurantDto(Restaurant restaurant) {
        this.id = restaurant.getId();
        this.name = restaurant.getName();
    }

    public static RestaurantDto buildFrom(Restaurant restaurant) {
        Assert.notNull(restaurant);
        return new RestaurantDto(restaurant);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
