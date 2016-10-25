package fr.test.testJpa.repository;

import static org.junit.Assert.*;

import fr.test.testJpa.model.Customer;
import fr.test.testJpa.model.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/testJpa-dao-test-context.xml"})
@Transactional

@Rollback(value = false)
public class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository repository;

	private static Long idCustomer;

	@Test
	public void testSave() {

		Customer customer1 = new Customer("fn1", "ln1");
		Customer customer2 = new Customer("fn2", "ln2");

		Order order1 = new Order("title1");
		Order order2 = new Order("title2");
		Order order3 = new Order("title3");


		customer1.getOrders().add(order1);
		customer1.getOrders().add(order2);
		customer1.getOrders().add(order3);

		customer2.getOrders().add(order1);

		Customer customer1Saved = repository.save(customer1);
		Customer customer2Saved = repository.save(customer2);

		assertNotNull(customer1Saved);
		assertNotNull(customer2Saved);

		assertEquals("fn1", customer1Saved.getFirstName());
		assertEquals("ln1", customer1Saved.getLastName());

		idCustomer = customer1Saved.getId();
		System.out.println("test");
	}

	@Test
	public void testRemove() {
		Customer customer = repository.getOne(idCustomer);

		List<Order> orders = customer.getOrders();
		boolean isRemoved = customer.getOrders().remove(orders.get(0));

		Assert.assertTrue(isRemoved);
	}

}
