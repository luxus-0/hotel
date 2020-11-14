package lukasz.nowogorski.infrastructure.postgres;

import lukasz.nowogorski.domain.model.Employee;
import lukasz.nowogorski.domain.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

    @Query(value = "SELECT * FROM Employee e WHERE g.name = ?"
            ,nativeQuery = true)
    List<Employee> findByName(String name);

    @Query(value = "SELECT * FROM Employee e WHERE e.secondName = ?"
            ,nativeQuery = true)
    List<Employee> findBySecondName(String secondName);

    @Query(value = "SELECT * FROM Employee e WHERE e.surname = ?"
            ,nativeQuery = true)
    List<Employee> findBySurname(String surname);

    @Query(value = "SELECT * FROM Employee e WHERE e.gender = ?"
            ,nativeQuery = true)
    List<Employee> findByGender(Gender gender);

    @Query(value = "SELECT * FROM Employee e WHERE e.pesel = ?"
            ,nativeQuery = true)
    List<Employee> findByPesel(Long pesel);

    @Query(value = "SELECT * FROM Employee e WHERE e.nationality = ?"
            ,nativeQuery = true)
    List<Employee> findByNationality(String nationality);

    @Query(value = "SELECT * FROM Employee e WHERE e.dateOfBirth = ?"
            ,nativeQuery = true)
    List<Employee> findByDateOfBirth(LocalDate dateOfBirth);

    @Query(value = "SELECT * FROM Employee e WHERE e.telephone = ?"
            ,nativeQuery = true)
    List<Employee> findByTelephone(String telephone);

    @Query(value = "SELECT * FROM Employee e WHERE e.email = ?"
            ,nativeQuery = true)
    List<Employee> findByEmail(String telephone);


    @Modifying
    @Query(value = "UPDATE Employee e set e.id = ? where e.id = ?",
            nativeQuery = true)
    Employee update(Employee employee,Long id);
}
