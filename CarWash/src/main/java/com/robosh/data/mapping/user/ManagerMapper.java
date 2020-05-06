package com.robosh.data.mapping.user;

import com.robosh.data.dto.user.manager.InfoManagerDto;
import com.robosh.data.dto.user.manager.SaveManagerDto;
import com.robosh.data.entity.user.Manager;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ManagerMapper {

  Manager fromSaveManagerDtoToManager(SaveManagerDto saveManagerDto);

  Manager fromInfoManagerDtoToManager(InfoManagerDto saveManagerDto);

  SaveManagerDto fromManagerToSaveManagerDto(Manager manager);

  InfoManagerDto fromManagerToInfoManagerDto(Manager manager);

  List<InfoManagerDto> fromManagersToInfoManagerDtos(List<Manager> managers);
}
