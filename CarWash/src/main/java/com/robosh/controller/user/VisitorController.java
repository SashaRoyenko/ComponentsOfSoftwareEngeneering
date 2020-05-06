package com.robosh.controller.user;

import com.robosh.data.dto.user.InfoUserDto;
import com.robosh.data.dto.user.visitor.InfoVisitorDto;
import com.robosh.data.dto.user.visitor.SaveVisitorDto;
import com.robosh.service.user.VisitorService;
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
@RequestMapping("/visitors")
public class VisitorController {

  private final VisitorService visitorService;

  @GetMapping
  public List<InfoVisitorDto> getAllVisitors() {
    return visitorService.findAll();
  }

  @PostMapping
  public InfoUserDto saveVisitor(@RequestBody SaveVisitorDto saveVisitorDto) {
    return visitorService.save(saveVisitorDto);
  }

  @PutMapping
  public InfoVisitorDto updateVisitor(@RequestBody SaveVisitorDto saveVisitorDto) {
    return visitorService.update(saveVisitorDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteVisitor(@PathVariable Long id) {
    return visitorService.delete(id);
  }
}
