package fr.test.testJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.test.testJpa.model.Manager;

import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{

}
