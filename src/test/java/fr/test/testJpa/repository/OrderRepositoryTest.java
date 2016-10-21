package fr.test.testJpa.repository;

import static org.junit.Assert.*;

import fr.test.testJpa.model.Manager;
import fr.test.testJpa.model.Order;
import fr.test.testJpa.model.Restaurant;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/testJpa-dao-test-context.xml"})
@Transactional

public class OrderRepositoryTest {

	@Autowired
	private OrderRepository repo;

	@Autowired
	private RestaurantRepository restaurantRepository;

	@Test
	public void testSave() {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("RestaurantTest");

		Order order1 = new Order();
		order1.setTitle("Order1");
		order1.setRestaurant(restaurant);

		Order order1Saved = repo.save(order1);

		Assert.assertEquals("Order1", order1Saved.getTitle());
		Restaurant retaurantSaved = order1Saved.getRestaurant();
		Assert.assertEquals("RestaurantTest", retaurantSaved.getName());
	}

}
