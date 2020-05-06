package com.robosh.data.mapping;

import com.robosh.data.dto.ScheduleDto;
import com.robosh.data.entity.Schedule;
import java.util.List;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

  @Mapping(target = "employee.id", source = "employeeId")
  Schedule fromScheduleDtoToSchedule(ScheduleDto scheduleDto);

  @InheritInverseConfiguration
  ScheduleDto fromScheduleToScheduleDto(Schedule schedule);

  List<Schedule> fromScheduleDtosToSchedules(List<ScheduleDto> scheduleDtos);

  List<ScheduleDto> fromSchedulesToScheduleDtos(List<Schedule> schedules);

}
