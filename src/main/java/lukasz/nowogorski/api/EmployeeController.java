package lukasz.nowogorski.api;

import io.swagger.annotations.ApiOperation;
import lukasz.nowogorski.domain.model.Gender;
import lukasz.nowogorski.domain.model.Employee;
import lukasz.nowogorski.domain.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class EmployeeController {
    
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

        @GetMapping("/employees")
        @ApiOperation(value = "find employee")
        public List<Employee> getEmployee()
        {
            return employeeService.findEmployee();
        }

        @GetMapping("/employees/{id}")
        @ApiOperation(value = "find by id")
        public Employee getEmployeeById(@PathVariable("id") Long id)
        {
            return employeeService.findEmployeeById(id);
        }

        @GetMapping("/employees/{name}")
        @ApiOperation(value = "find by name")
        public List<Employee> getEmployeeByName(@PathVariable("name") String name)
        {
            return employeeService.findEmployeeByName(name);
        }

        @GetMapping("/employees/{secondName}")
        @ApiOperation(value = "find by secondName")
        public List<Employee> getEmployeeBySecondName(@PathVariable("secondName") String secondName)
        {
            return employeeService.findEmployeeBySecondName(secondName);
        }


        @GetMapping("/employees/{surname}")
        @ApiOperation(value = "find by surname")
        public List<Employee> getEmployeeBySurname(@PathVariable("surname") String surname)
        {
            return employeeService.findEmployeeBySurname(surname);
        }

        @GetMapping("/employees/{gender}")
        @ApiOperation(value = "find by gender")
        public List<Employee> getEmployeeByGender(@PathVariable("gender") Gender gender)
        {
            return employeeService.findEmployeeByGender(gender);
        }

        @GetMapping("/employees/{pesel}")
        @ApiOperation(value = "find by pesel")
        public List<Employee> getEmployeeByPesel(@PathVariable("pesel") Long pesel)
        {
            return employeeService.findEmployeeByPesel(pesel);
        }

        @GetMapping("/employees/{nationality}")
        @ApiOperation(value = "find by nationality")
        public List<Employee> getEmployeeByNationality(@PathVariable("nationality") String nationality)
        {
            return employeeService.findEmployeeByNationality(nationality);
        }

        @GetMapping("/employees/{dateOfBirth}")
        @ApiOperation(value = "find by dateOfBirth")
        public List<Employee> getEmployeeByDateOfBirth(@PathVariable("dateOfBirth") LocalDateTime dateOfBirth)
        {
            return employeeService.findEmployeeByDateOfBirth(dateOfBirth);
        }

        @GetMapping("/employees/{telephone}")
        @ApiOperation(value = "find by telephone")
        public List<Employee> getEmployeeByTelephone(@PathVariable("telephone") String telephone)
        {
            return employeeService.findEmployeeByTelephone(telephone);
        }

        @GetMapping("/employees/{email}")
        @ApiOperation(value = "find by email")
        public List<Employee> getEmployeeByEmail(@PathVariable("email") String email)
        {
            return employeeService.findEmployeeByEmail(email);
        }

        @PostMapping("/employees")
        @ApiOperation(value = "save Employee")
        public Employee addEmployee(@RequestBody Employee Employee)
        {
            return employeeService.saveEmployee(Employee);
        }

        @PutMapping("/employees/{id]")
        @ApiOperation(value = "update Employee")
        public Employee updateEmployee(@RequestBody Employee Employee,@PathVariable("id") Long id)
        {
            return employeeService.updateEmployee(Employee,id);
        }

        @DeleteMapping("/employees")
        @ApiOperation(value = "delete Employee")
        public void deleteEmployee()
        {
            employeeService.deleteEmployee();
        }

        @DeleteMapping("/employees/{id}")
        @ApiOperation(value = "delete id")
        public void deleteEmployee(@PathVariable("id") Long id)
        {
            employeeService.deleteEmployeeById(id);
        }
    }
