package fr.test.testJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fr.test.testJpa.model.Manager;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{

}
