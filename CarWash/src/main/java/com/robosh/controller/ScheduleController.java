package com.robosh.controller;

import com.robosh.data.dto.ScheduleDto;
import com.robosh.service.ScheduleService;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedules")
public class ScheduleController {

  private final ScheduleService scheduleService;

  @GetMapping("/employees/{id}")
  public List<ScheduleDto> getScheduleForEmployee(@PathVariable Long id) {
    return scheduleService.findEmployeeSchedule(id);
  }


  @GetMapping
  public List<ScheduleDto> getScheduleByDates(
      @RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate startDate,
      @RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate endDate) {
    return scheduleService.findAll(startDate, endDate);
  }


  @PostMapping
  public ScheduleDto saveEmployee(@RequestBody ScheduleDto scheduleDto) {
    return scheduleService.save(scheduleDto);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity deleteEmployee(@PathVariable Long id) {
    return scheduleService.delete(id);
  }
}
