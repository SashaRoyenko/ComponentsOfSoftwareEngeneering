package com.robosh.service;


import com.robosh.data.dto.ScheduleDto;
import com.robosh.data.entity.Schedule;
import com.robosh.data.mapping.ScheduleMapper;
import com.robosh.data.repository.ScheduleRepository;
import com.robosh.exception.ResourceNotFoundException;
import java.time.LocalDate;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {

  private final ScheduleRepository scheduleRepository;
  private final ScheduleMapper scheduleMapper;
  private final ModelMapper modelMapper;

  public List<ScheduleDto> findEmployeeSchedule(Long id) {
    return scheduleMapper.fromSchedulesToScheduleDtos(
        scheduleRepository.findByEmployeeId(id));
  }

  public List<ScheduleDto> findAll(LocalDate start, LocalDate end) {
    if (start.compareTo(end) > 0) {
      LocalDate temp = end;
      end = start;
      start = temp;
    }

    return scheduleMapper.fromSchedulesToScheduleDtos(
        scheduleRepository.findByDateBetween(start, end));
  }

  public ScheduleDto save(ScheduleDto scheduleDto) {
    Schedule toSave = scheduleMapper.fromScheduleDtoToSchedule(scheduleDto);
    return scheduleMapper.fromScheduleToScheduleDto(
        scheduleRepository.save(toSave)
    );
  }

  public ScheduleDto update(ScheduleDto scheduleDto) {
    Schedule currentSchedule = findById(scheduleDto.getId());
    Schedule updateSchedule = scheduleMapper.fromScheduleDtoToSchedule(scheduleDto);

    modelMapper.map(updateSchedule, currentSchedule);
    scheduleRepository.save(currentSchedule);

    return scheduleMapper.fromScheduleToScheduleDto(currentSchedule);
  }

  public Schedule findById(Long id) {
    return scheduleRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Schedule", "id", id)
    );
  }

  public ResponseEntity delete(Long id) {
    Schedule scheduleToDelete = findById(id);
    scheduleRepository.delete(scheduleToDelete);
    return ResponseEntity.ok().build();
  }

}

