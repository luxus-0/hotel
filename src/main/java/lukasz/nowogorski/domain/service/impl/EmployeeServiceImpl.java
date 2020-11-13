package lukasz.nowogorski.domain.service.impl;

import lukasz.nowogorski.domain.model.Employee;
import lukasz.nowogorski.domain.model.Gender;
import lukasz.nowogorski.domain.service.EmployeeService;
import lukasz.nowogorski.infrastructure.postgres.EmployeeRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

   @Override
    public List<Employee> findEmployee() {
        return repository.findAll();
    }

    @Override
    public Employee findEmployeeById(Long id) {
        Optional<Employee> employeeOptional = repository.findById(id);
        return employeeOptional.orElseThrow(() -> new EntityNotFoundException("No employee with such id: " +id));
    }

    @Override
    public List<Employee> findEmployeeByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<Employee> findEmployeeBySecondName(String secondName) {
        return repository.findBySecondName(secondName);
    }

    @Override
    public List<Employee> findEmployeeBySurname(String surname) {
        return repository.findBySurname(surname);
    }

    @Override
    public List<Employee> findEmployeeByGender(Gender gender) {
        return repository.findByGender(gender);
    }

    @Override
    public List<Employee> findEmployeeByPesel(Long pesel) {
        return repository.findByPesel(pesel);
    }

    @Override
    public List<Employee> findEmployeeByNationality(String nationality) {
        return repository.findByNationality(nationality);
    }

    @Override
    public List<Employee> findEmployeeByDateOfBirth(LocalDateTime dateOfBirth) {
        return repository.findByDateOfBirth(dateOfBirth);
    }

    @Override
    public List<Employee> findEmployeeByTelephone(String telephone) {
        return repository.findByTelephone(telephone);
    }

    @Override
    public List<Employee> findEmployeeByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee updateEmployee(Employee employee, Long id) {
        return repository.update(employee,id);
    }

    @Override
    public void deleteEmployee() {
        repository.deleteAll();
    }

    @Override
    public void deleteEmployeeById(Long id) {
        repository.deleteById(id);
    }

}
