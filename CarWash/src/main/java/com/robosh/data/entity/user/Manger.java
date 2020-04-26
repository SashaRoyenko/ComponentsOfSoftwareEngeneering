package com.robosh.data.entity.user;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Manger extends User {

  @Builder
  public Manger(Long id, String firstName, String secondName,
      String email, String password) {
    super(id, firstName, secondName, email, password);
  }
}
