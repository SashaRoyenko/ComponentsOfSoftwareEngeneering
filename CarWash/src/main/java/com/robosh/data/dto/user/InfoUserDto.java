package com.robosh.data.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InfoUserDto {

  private Long id;

  private String firstName;

  private String secondName;

  private String email;

}
