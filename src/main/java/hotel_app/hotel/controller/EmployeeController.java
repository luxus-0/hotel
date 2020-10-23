package hotel_app.hotel.controller;

import hotel_app.hotel.entity.Customer;
import hotel_app.hotel.entity.Employee;
import hotel_app.hotel.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private static final Logger log = LoggerFactory.getLogger(EmployeeController.class);
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @GetMapping
    ResponseEntity<List<Employee>> read() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Employee> read(Long id) {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/{page}")
    ResponseEntity<Page<Employee>> read(@RequestParam Pageable page) {
        return ResponseEntity.ok(employeeRepository.findAll(page));
    }

    @GetMapping("/{sort}")
    ResponseEntity<List<Employee>> read(@RequestParam Sort sort) {
        return ResponseEntity.ok(employeeRepository.findAll(sort));
    }


    @PostMapping
    ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee employees = employeeRepository.save(employee);
        return ResponseEntity.created(URI.create("/" + employees.getId())).body(employee);
    }

    @PutMapping("/{id}")
    ResponseEntity<Customer> update(@RequestBody Employee employee, @PathVariable Long id) {
        if (!employeeRepository.existsById(id)) {
            ResponseEntity.notFound().build();
        }
        employee.setId(id);
        employeeRepository.save(employee);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping
    void delete() {
    employeeRepository.deleteAll();
    }

    @DeleteMapping("/{id}")
    void deleteById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }
}
