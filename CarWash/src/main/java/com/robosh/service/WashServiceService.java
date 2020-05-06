package com.robosh.service;

import com.robosh.data.dto.WashServiceDto;
import com.robosh.data.entity.WashService;
import com.robosh.data.mapping.WashServiceMapper;
import com.robosh.data.repository.WashServiceRepository;
import com.robosh.exception.ResourceNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WashServiceService {

  private final WashServiceMapper washServiceMapper;
  private final WashServiceRepository washServiceRepository;
  private final ModelMapper modelMapper;

  public WashServiceDto save(WashServiceDto washServiceDto) {
    WashService washServiceToSave = washServiceMapper.fromServiceDtoToService(washServiceDto);
    WashService resultWashService = washServiceRepository.save(washServiceToSave);
    return washServiceMapper.fromServiceToServiceDto(resultWashService);
  }

  public List<WashServiceDto> findAll() {
    List<WashService> washServiceList = washServiceRepository.findAll();
    return washServiceMapper.fromWashServicesToInfoWashServiceDtos(washServiceList);
  }

  public WashServiceDto update(WashServiceDto saveWashServiceDto) {
    WashService currentWashService = findById(saveWashServiceDto.getId());
    WashService updateWashService = washServiceMapper.fromServiceDtoToService(saveWashServiceDto);

    modelMapper.map(updateWashService, currentWashService);
    washServiceRepository.save(currentWashService);

    return washServiceMapper.fromServiceToServiceDto(currentWashService);
  }

  public ResponseEntity delete(Long id) {
    WashService washServiceToDelete = findById(id);
    washServiceRepository.delete(washServiceToDelete);
    return ResponseEntity.ok().build();
  }

  public WashService findById(Long id) {
    return washServiceRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("WashService", "id", id)
    );
  }

}
