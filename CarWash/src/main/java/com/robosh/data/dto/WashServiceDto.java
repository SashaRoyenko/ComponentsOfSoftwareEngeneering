package com.robosh.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WashServiceDto {

  private Long id;

  private String serviceType;

  private float price;

}
