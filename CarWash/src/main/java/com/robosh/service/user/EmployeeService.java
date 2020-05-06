package com.robosh.service.user;

import com.robosh.data.dto.user.employee.InfoEmployeeDto;
import com.robosh.data.dto.user.employee.SaveEmployeeDto;
import com.robosh.data.entity.user.Employee;
import com.robosh.data.mapping.user.EmployeeMapper;
import com.robosh.data.repository.user.EmployeeRepository;
import com.robosh.exception.ResourceNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

  private final EmployeeRepository employeeRepository;
  private final EmployeeMapper employeeMapper;
  private final ModelMapper modelMapper;

  public InfoEmployeeDto save(SaveEmployeeDto saveEmployeeDto) {
    Employee employeeToSave = employeeMapper.fromSaveEmployeeDtoToEmployee(saveEmployeeDto);
    Employee resultEmployee = employeeRepository.save(employeeToSave);
    return employeeMapper.fromEmployeeToInfoEmployeeDto(resultEmployee);
  }

  public List<InfoEmployeeDto> findAll() {
    List<Employee> employeeList = employeeRepository.findAll();
    return employeeMapper.fromEmployeesToInfoEmployeeDtos(employeeList);
  }

  public InfoEmployeeDto update(SaveEmployeeDto saveEmployeeDto) {
    Employee currentEmployee = findById(saveEmployeeDto.getId());
    Employee updateEmployee = employeeMapper.fromSaveEmployeeDtoToEmployee(saveEmployeeDto);

    modelMapper.map(updateEmployee, currentEmployee);
    employeeRepository.save(currentEmployee);

    return employeeMapper.fromEmployeeToInfoEmployeeDto(currentEmployee);
  }

  public ResponseEntity delete(Long id) {
    Employee employeeToDelete = findById(id);
    employeeRepository.delete(employeeToDelete);
    return ResponseEntity.ok().build();
  }

  public Employee findById(Long id) {
    return employeeRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Employee", "id", id)
    );
  }

}
