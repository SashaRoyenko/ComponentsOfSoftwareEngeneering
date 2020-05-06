package com.robosh.data.dto.user.visitor;

import com.robosh.data.dto.user.SaveUserDto;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class SaveVisitorDto extends SaveUserDto {

  float discount;

  @Builder
  public SaveVisitorDto(Long id, String firstName, String secondName,
      String email, String password, float discount) {
    super(id, firstName, secondName, email, password);
    this.discount = discount;
  }
}
