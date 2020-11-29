package lukasz.nowogorski.mapper;

import lukasz.nowogorski.model.Employee;
import lukasz.nowogorski.dto.EmployeeDto;

public interface EmployeeMapper {

    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
    EmployeeDto employeeToEmployeeDto(Employee employee);
}
