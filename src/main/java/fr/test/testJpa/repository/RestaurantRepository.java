package fr.test.testJpa.repository;

import fr.test.testJpa.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by trong.nguyen on 18/10/2016.
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
}
