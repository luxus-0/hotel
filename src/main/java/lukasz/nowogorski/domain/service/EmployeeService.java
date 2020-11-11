package lukasz.nowogorski.domain.service;

import lukasz.nowogorski.domain.model.Employee;
import lukasz.nowogorski.domain.model.Gender;

import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeService {

    List<Employee> findEmployee();
    Employee findEmployeeById(Long id);
    List<Employee> findEmployeeByName(String name);
    List<Employee> findEmployeeBySecondName(String secondName);
    List<Employee> findEmployeeBySurname(String surname);
    List<Employee> findEmployeeByGender(Gender gender);
    List<Employee> findEmployeeByPesel(Long pesel);
    List<Employee> findEmployeeByNationality(String nationality);
    List<Employee> findEmployeeByDateOfBirth(LocalDateTime dateOfBirth);
    List<Employee> findEmployeeByTelephone(String telephone);
    List<Employee> findEmployeeByEmail(String email);
    Employee saveEmployee(Employee employee);
    Employee updateEmployee(Employee employee, Long id);
    void deleteEmployee();
    void deleteEmployeeById(Long id);
}
