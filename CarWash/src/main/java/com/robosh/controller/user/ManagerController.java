package com.robosh.controller.user;

import com.robosh.data.dto.user.InfoUserDto;
import com.robosh.data.dto.user.manager.InfoManagerDto;
import com.robosh.data.dto.user.manager.SaveManagerDto;
import com.robosh.service.user.ManagerService;
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
@RequestMapping("/managers")
public class ManagerController {

  private final ManagerService managerService;

  @GetMapping
  public List<InfoManagerDto> getAllManagers() {
    return managerService.findAll();
  }

  @PostMapping
  public InfoUserDto saveManager(@RequestBody SaveManagerDto saveManagerDto) {
    return managerService.save(saveManagerDto);
  }

  @PutMapping
  public InfoManagerDto updateManager(@RequestBody SaveManagerDto saveManagerDto) {
    return managerService.update(saveManagerDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteManager(@PathVariable Long id) {
    return managerService.delete(id);
  }

}
