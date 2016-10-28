package fr.test.testJpa.repository;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.test.testJpa.model.Manager;
import fr.test.testJpa.model.Restaurant;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/testJpa-dao-test-context.xml"})
@Transactional

public class ManagerRepositoryTest {
	
	@Autowired
	private ManagerRepository repo;

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Test
	public void testSave() {

		Restaurant restaurant = new Restaurant();
		restaurant.setName("restaurant" + Math.random());
		Restaurant restaurantSaved = restaurantRepository.save(restaurant);

		Manager manager = new Manager();
		manager.setFirstName("firstName1");
		manager.setLastName("lastName1");
		manager.setRestaurant(restaurantSaved);
		
		Manager managerSaved = repo.save(manager);
		
		assertEquals("firstName1", managerSaved.getFirstName());
		assertEquals("lastName1", managerSaved.getLastName());
		
	}

	@Test
	public void testAddRestaurantExist() {
		Restaurant restaurant = restaurantRepository.getOne(5000L);

		Manager manager2 = new Manager("fn2", "ln2", restaurant);
        Manager managerSaved = repo.save(manager2);

        Manager managerFound = repo.getOne(managerSaved.getId());

        assertEquals("fn2", managerSaved.getFirstName());
        assertEquals("ln2", managerSaved.getLastName());
    }


}
