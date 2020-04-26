package com.robosh.data.entity.user;

import javax.persistence.Entity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
public class Employee extends User {

  @Builder
  public Employee(Long id, String firstName, String secondName,
      String email, String password) {
    super(id, firstName, secondName, email, password);
  }

}
