package com.robosh.controller;

import com.robosh.data.dto.WashServiceDto;
import com.robosh.service.WashServiceService;
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
@RequestMapping("/washservices")
public class WashServiceController {

  private final WashServiceService washServiceService;

  @GetMapping
  public List<WashServiceDto> getAllWashService() {
    return washServiceService.findAll();
  }

  @PostMapping
  public WashServiceDto saveEmployee(@RequestBody WashServiceDto washServiceDto) {
    return washServiceService.save(washServiceDto);
  }

  @PutMapping
  public WashServiceDto updateEmployee(@RequestBody WashServiceDto washServiceDto) {
    return washServiceService.update(washServiceDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteEmployee(@PathVariable Long id) {
    return washServiceService.delete(id);
  }
}
