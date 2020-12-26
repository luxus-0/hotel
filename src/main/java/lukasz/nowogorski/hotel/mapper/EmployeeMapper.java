package lukasz.nowogorski.hotel.mapper;

import lukasz.nowogorski.hotel.model.Employee;
import lukasz.nowogorski.hotel.dto.EmployeeDto;

public interface EmployeeMapper {

    Employee employeeDtoToEmployee(EmployeeDto employeeDto);
    EmployeeDto employeeToEmployeeDto(Employee employee);
}
