package com.robosh.data.mapping;

import com.robosh.data.dto.WashServiceDto;
import com.robosh.data.entity.WashService;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WashServiceMapper {

  WashService fromServiceDtoToService(WashServiceDto washServiceDto);

  WashServiceDto fromServiceToServiceDto(WashService washService);

  List<WashServiceDto> fromWashServicesToInfoWashServiceDtos(List<WashService> washServiceList);
}
