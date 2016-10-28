package fr.test.testJpa.repository;

import fr.test.testJpa.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by trong.nguyen on 18/10/2016.
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{

    @Query("select res.name from Restaurant res where res.id = :id")
    Optional<String> findNameById(@Param("id") Long id);
}
