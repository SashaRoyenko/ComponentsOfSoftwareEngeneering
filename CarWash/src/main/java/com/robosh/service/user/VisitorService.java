package com.robosh.service.user;

import com.robosh.data.dto.user.visitor.InfoVisitorDto;
import com.robosh.data.dto.user.visitor.SaveVisitorDto;
import com.robosh.data.entity.user.Visitor;
import com.robosh.data.mapping.user.VisitorMapper;
import com.robosh.data.repository.user.VisitorRepository;
import com.robosh.exception.ResourceNotFoundException;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitorService {

  private final VisitorRepository visitorRepository;
  private final VisitorMapper visitorMapper;
  private final ModelMapper modelMapper;

  public InfoVisitorDto save(SaveVisitorDto saveVisitorDto) {
    Visitor visitorToSave = visitorMapper.fromSaveVisitorDtoToVisitor(saveVisitorDto);
    Visitor resultVisitor = visitorRepository.save(visitorToSave);
    return visitorMapper.fromVisitorToInfoVisitorDto(resultVisitor);
  }

  public List<InfoVisitorDto> findAll() {
    List<Visitor> visitorList = visitorRepository.findAll();
    return visitorMapper.fromVisitorsToInfoVisitorDtos(visitorList);
  }

  public InfoVisitorDto update(SaveVisitorDto saveVisitorDto) {
    Visitor currentVisitor = findById(saveVisitorDto.getId());
    Visitor updateVisitor = visitorMapper.fromSaveVisitorDtoToVisitor(saveVisitorDto);

    modelMapper.map(updateVisitor, currentVisitor);
    visitorRepository.save(currentVisitor);

    return visitorMapper.fromVisitorToInfoVisitorDto(currentVisitor);
  }

  public ResponseEntity delete(Long id) {
    Visitor visitorToDelete = findById(id);
    visitorRepository.delete(visitorToDelete);
    return ResponseEntity.ok().build();
  }

  public Visitor findById(Long id) {
    return visitorRepository.findById(id).orElseThrow(
        () -> new ResourceNotFoundException("Visitor", "id", id)
    );
  }
}
