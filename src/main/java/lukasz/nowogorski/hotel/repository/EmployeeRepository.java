package lukasz.nowogorski.hotel.repository;

import lukasz.nowogorski.hotel.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query("SELECT e FROM Employee e WHERE e.name = ?1 AND e.surname = ?2")
    Employee findEmployeeByNameAndSurname(String name,String surname);


    @Modifying
    @Query(value = "UPDATE Employee e SET e.id = ?1 WHERE e.id = ?1")
    Employee updateEmployee(Employee employee,Long id);
}
