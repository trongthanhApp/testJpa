package fr.test.testJpa.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.test.testJpa.service.RestaurantService;
import fr.test.testJpa.service.dto.RestaurantDto;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService{


    @Override
    public RestaurantDto create(RestaurantDto dto) {
        return null;
    }
}
