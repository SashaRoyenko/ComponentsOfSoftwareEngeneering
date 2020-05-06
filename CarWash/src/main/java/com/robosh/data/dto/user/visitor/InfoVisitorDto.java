package com.robosh.data.dto.user.visitor;

import com.robosh.data.dto.user.InfoUserDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class InfoVisitorDto extends InfoUserDto {

  float discount;

  @Builder
  public InfoVisitorDto(Long id, String firstName, String secondName,
      String email, float discount) {
    super(id, firstName, secondName, email);
    this.discount = discount;
  }

}
