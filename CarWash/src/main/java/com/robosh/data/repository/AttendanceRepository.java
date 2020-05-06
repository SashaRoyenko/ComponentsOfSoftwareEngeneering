package com.robosh.data.repository;

import com.robosh.data.entity.Attendance;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

  List<Attendance> findAttendanceByTimeBetween(LocalDateTime start, LocalDateTime end);

  List<Attendance> findAttendanceByVisitorId(Long id);
}
