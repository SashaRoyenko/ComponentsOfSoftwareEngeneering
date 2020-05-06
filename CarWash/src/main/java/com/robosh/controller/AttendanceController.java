package com.robosh.controller;

import com.robosh.data.dto.AttendanceDto;
import com.robosh.service.AttendanceService;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/attendances")
public class AttendanceController {

  private final AttendanceService attendanceService;

  @PostMapping
  public AttendanceDto save(@RequestBody AttendanceDto attendanceDto) {
    return attendanceService.save(attendanceDto);
  }

  @GetMapping("/visitors/{id}")
  public List<AttendanceDto> getByVisitorId(@PathVariable Long id) {
    return attendanceService.findByVisitorId(id);
  }

  @GetMapping
  public List<AttendanceDto> getByTimeBetween(
      @RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate startDate,
      @RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate endDate) {
    LocalDateTime start = startDate.atStartOfDay();
    LocalDateTime end = endDate.atStartOfDay().plusDays(1);
    return attendanceService.findAttendanceByTimeBetween(start, end);
  }
}