package com.robosh.controller.user;

import com.robosh.data.dto.user.employee.InfoEmployeeDto;
import com.robosh.data.dto.user.employee.SaveEmployeeDto;
import com.robosh.service.user.EmployeeService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employees")
public class EmployeeController {

  private final EmployeeService employeeService;

  @GetMapping
  public List<InfoEmployeeDto> getAllEmployees() {
    return employeeService.findAll();
  }

  @PostMapping
  public InfoEmployeeDto saveEmployee(@RequestBody SaveEmployeeDto saveEmployeeDto) {
    return employeeService.save(saveEmployeeDto);
  }

  @PutMapping
  public InfoEmployeeDto updateEmployee(@RequestBody SaveEmployeeDto saveEmployeeDto) {
    return employeeService.update(saveEmployeeDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteEmployee(@PathVariable Long id) {
    return employeeService.delete(id);
  }

}
