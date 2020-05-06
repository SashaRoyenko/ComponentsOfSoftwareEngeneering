package com.robosh.service.user;

import com.robosh.data.dto.user.manager.InfoManagerDto;
import com.robosh.data.dto.user.manager.SaveManagerDto;
import com.robosh.data.entity.user.Manager;
import com.robosh.data.mapping.user.ManagerMapper;
import com.robosh.data.repository.user.ManagerRepository;
import com.robosh.exception.ResourceNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ManagerService {

  private final ManagerRepository managerRepository;
  private final ManagerMapper managerMapper;
  private final ModelMapper modelMapper;

  public InfoManagerDto save(SaveManagerDto saveManagerDto) {
    Manager managerToSave = managerMapper.fromSaveManagerDtoToManager(saveManagerDto);
    Manager resultManager = managerRepository.save(managerToSave);
    return managerMapper.fromManagerToInfoManagerDto(resultManager);
  }

  public List<InfoManagerDto> findAll() {
    List<Manager> managerList = managerRepository.findAll();
    return managerMapper.fromManagersToInfoManagerDtos(managerList);
  }

  public InfoManagerDto update(SaveManagerDto saveManagerDto) {
    Manager currentManager = findById(saveManagerDto.getId());
    Manager updateManager = managerMapper.fromSaveManagerDtoToManager(saveManagerDto);

    modelMapper.map(updateManager, currentManager);
    managerRepository.save(currentManager);

    return managerMapper.fromManagerToInfoManagerDto(currentManager);
  }

  public ResponseEntity delete(Long id) {
    Manager managerToDelete = findById(id);
    managerRepository.delete(managerToDelete);
    return ResponseEntity.ok().build();
  }

  public Manager findById(Long id) {
    return managerRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Manager", "id", id)
    );
  }
}
