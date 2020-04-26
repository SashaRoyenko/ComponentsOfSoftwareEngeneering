package com.robosh.data.entity.user;

import javax.persistence.Column;
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
public class Visitor extends User {

  @Column(precision = 2)
  float discount;

  @Builder
  public Visitor(Long id, String firstName, String secondName,
      String email, String password, float discount) {
    super(id, firstName, secondName, email, password);
    this.discount = discount;
  }
}
