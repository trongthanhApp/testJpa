package fr.test.testJpa.service.impl;

import fr.test.testJpa.model.Restaurant;
import fr.test.testJpa.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.test.testJpa.service.RestaurantService;
import fr.test.testJpa.service.dto.RestaurantDto;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public RestaurantDto create(RestaurantDto dto) {

        Restaurant restaurant = new Restaurant(dto.getName());
        Restaurant restaurantSaved = restaurantRepository.save(restaurant);

        return RestaurantDto.buildFrom(restaurantSaved);
    }
}
