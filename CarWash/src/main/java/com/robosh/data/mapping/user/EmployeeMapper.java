package com.robosh.data.mapping.user;

import com.robosh.data.dto.user.employee.InfoEmployeeDto;
import com.robosh.data.dto.user.employee.SaveEmployeeDto;
import com.robosh.data.entity.user.Employee;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

  Employee fromSaveEmployeeDtoToEmployee(SaveEmployeeDto saveEmployeeDto);

  Employee fromInfoEmployeeDtoToEmployee(InfoEmployeeDto saveEmployeeDto);

  SaveEmployeeDto fromEmployeeToSaveEmployeeDto(Employee employee);

  InfoEmployeeDto fromEmployeeToInfoEmployeeDto(Employee employee);

  List<InfoEmployeeDto> fromEmployeesToInfoEmployeeDtos(List<Employee> employees);
}
