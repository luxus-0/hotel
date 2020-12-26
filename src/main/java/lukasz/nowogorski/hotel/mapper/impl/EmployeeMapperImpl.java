package lukasz.nowogorski.hotel.mapper.impl;

import lukasz.nowogorski.hotel.model.Employee;
import lukasz.nowogorski.hotel.dto.EmployeeDto;
import lukasz.nowogorski.hotel.mapper.EmployeeMapper;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapperImpl implements EmployeeMapper {
    @Override
    public Employee employeeDtoToEmployee(EmployeeDto employeeDto) {
        return Employee.builder()
                .id(employeeDto.getId())
                .name(employeeDto.getName())
                .secondName(employeeDto.getSecondName())
                .surname(employeeDto.getSurname())
                .gender(employeeDto.getGender())
                .email(employeeDto.getEmail())
                .build();
    }

    @Override
    public EmployeeDto employeeToEmployeeDto(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .secondName(employee.getSecondName())
                .surname(employee.getSurname())
                .gender(employee.getGender())
                .email(employee.getEmail())
                .build();
    }
}
