package com.robosh.data.repository;

import com.robosh.data.entity.Schedule;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

  List<Schedule> findByEmployeeId(Long id);

  List<Schedule> findByDateBetween(LocalDate start, LocalDate end);
}
