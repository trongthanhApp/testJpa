package fr.test.testJpa.repository;

import fr.test.testJpa.model.Restaurant;

import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:testJpa-dao-test-context.xml"})
@Transactional
public class RestaurantRepository2Test {

	@Autowired
	private RestaurantRepository repo;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testSave2() {
		Restaurant restaurant = new Restaurant();
		restaurant.setTitle("title2");

		Restaurant restaurantSaved = repo.save(restaurant);
		Assert.assertNotNull(restaurantSaved);
		Assert.assertEquals("title2", restaurantSaved.getTitle());
	}

}
