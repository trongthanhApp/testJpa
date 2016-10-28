package fr.test.testJpa.repository;

import fr.test.testJpa.model.Order;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import fr.test.testJpa.model.Restaurant;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:testJpa-dao-test-context.xml"})
@Transactional
public class RestaurantRepositoryTest {

	@Autowired
	private RestaurantRepository repo;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testSave() {
		Restaurant restaurant = new Restaurant();
		restaurant.setName("title1");

		Restaurant restaurantSaved = repo.save(restaurant);
		Assert.assertNotNull(restaurantSaved);
		assertEquals("title1", restaurantSaved.getName());
	}

	@Test
	public void testFindNameById() {
		Optional<String> restaurantName = repo.findNameById(5000L);

		assertEquals("resto1", restaurantName.get());
	}

	@Test
	public void testFindOrdersByRestaurantId() {
		List<Order> orders = repo.findOrdersByRestaurantId(5000L);

		assertNotNull(orders);
		assertEquals(3, orders.size());
	}

}
