package com.robosh.data.mapping.user;

import com.robosh.data.dto.user.visitor.InfoVisitorDto;
import com.robosh.data.dto.user.visitor.SaveVisitorDto;
import com.robosh.data.entity.user.Visitor;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitorMapper {

  Visitor fromSaveVisitorDtoToVisitor(SaveVisitorDto saveVisitorDto);

  Visitor fromInfoVisitorDtoToVisitor(InfoVisitorDto saveVisitorDto);

  SaveVisitorDto fromVisitorToSaveVisitorDto(Visitor visitor);

  InfoVisitorDto fromVisitorToInfoVisitorDto(Visitor visitor);

  List<InfoVisitorDto> fromVisitorsToInfoVisitorDtos(List<Visitor> visitorList);
}
