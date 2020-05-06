package com.robosh.data.mapping;

import com.robosh.data.dto.AttendanceDto;
import com.robosh.data.entity.Attendance;
import com.robosh.data.entity.WashService;
import java.util.List;
import java.util.stream.Collectors;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", imports = {Collectors.class, WashService.class})
public interface AttendanceMapper {

  @Mappings(value = {
      @Mapping(
          target = "washServices",
          expression = "java(attendanceDto.getServiceIds().stream()" +
              ".map((id)-> WashService.builder()" +
              ".id(id)" +
              ".build())" +
              ".collect(Collectors.toList()))"
      ),
      @Mapping(source = "visitorId", target = "visitor.id"),
      @Mapping(source = "employeeId", target = "employee.id")
  })
  Attendance fromAttendanceDtoToAttendance(AttendanceDto attendanceDto);

  @Mappings(value = {
      @Mapping(
          target = "serviceIds",
          expression = "java(attendance.getWashServices().stream()" +
              ".map(e->e.getId())" +
              ".collect(Collectors.toList()))"
      ),
      @Mapping(source = "visitor.id", target = "visitorId"),
      @Mapping(source = "employee.id", target = "employeeId")
  })
  AttendanceDto fromAttendanceToAttendanceDto(Attendance attendance);

  List<AttendanceDto> fromAttendancesToAttendanceDtos(List<Attendance> attendancesList);
}
