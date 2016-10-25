package fr.test.testJpa.repository;

import fr.test.testJpa.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findByFirstNameAndLastName(String firstName, String lastName);

    Optional<List<Customer>> findByFirstName(String firstName);
}
