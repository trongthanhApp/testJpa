package fr.test.testJpa.repository;

import fr.test.testJpa.model.Restaurant;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:testJpa-dao-context-oracle.xml"})
@Transactional
public class RestaurantRepositoryTestOracle {

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
		restaurant.setTitle("title1");

		Restaurant restaurantSaved = repo.save(restaurant);
		Assert.assertNotNull(restaurantSaved);
		Assert.assertEquals("title1", restaurantSaved.getTitle());
	}

}
