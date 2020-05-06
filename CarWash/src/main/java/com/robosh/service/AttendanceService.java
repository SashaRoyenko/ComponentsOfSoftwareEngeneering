package com.robosh.service;

import com.robosh.data.dto.AttendanceDto;
import com.robosh.data.entity.Attendance;
import com.robosh.data.entity.WashService;
import com.robosh.data.mapping.AttendanceMapper;
import com.robosh.data.repository.AttendanceRepository;
import com.robosh.data.repository.WashServiceRepository;
import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AttendanceService {

  private final AttendanceRepository attendanceRepository;
  private final WashServiceRepository washServiceRepository;
  private final AttendanceMapper attendanceMapper;

  public AttendanceDto save(AttendanceDto attendanceDto) {
    Attendance toSave = attendanceMapper.fromAttendanceDtoToAttendance(attendanceDto);
    float totalPrice = getTotalPrice(attendanceDto.getServiceIds());
    toSave.setTotalPrice(totalPrice);
    toSave.setTime(LocalDateTime.now());
    Attendance saved = attendanceRepository.save(toSave);
    return attendanceMapper.fromAttendanceToAttendanceDto(saved);
  }

  public List<AttendanceDto> findByVisitorId(Long id) {
    List<Attendance> attendanceList = attendanceRepository.findAttendanceByVisitorId(id);
    return attendanceMapper.fromAttendancesToAttendanceDtos(attendanceList);
  }

  public List<AttendanceDto> findAttendanceByTimeBetween(LocalDateTime start, LocalDateTime end) {
    List<Attendance> attendanceList = attendanceRepository.findAttendanceByTimeBetween(start, end);
    return attendanceMapper.fromAttendancesToAttendanceDtos(attendanceList);
  }

  private float getTotalPrice(List<Long> serviceIds) {
    List<WashService> washServiceList = washServiceRepository.findAllByIdIn(serviceIds);
    return washServiceList.stream()
        .map(WashService::getPrice)
        .reduce(Float::sum)
        .orElse(0.f);

  }

}
