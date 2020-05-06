package com.robosh.data.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDto {

  private Long visitorId;

  private Long employeeId;

  private List<Long> serviceIds;

  private float totalPrice;
}
