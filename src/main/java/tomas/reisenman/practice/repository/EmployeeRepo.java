package tomas.reisenman.practice.repository;


import tomas.reisenman.practice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    Optional<Employee> findByContactEmail(String cuitObteined);
}
