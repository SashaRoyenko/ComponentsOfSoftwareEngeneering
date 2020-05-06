package com.robosh.data.entity;

import com.robosh.data.entity.user.Employee;
import com.robosh.data.entity.user.Visitor;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Attendance {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne
  @JoinColumn(nullable = false)
  private Visitor visitor;

  @OneToOne
  @JoinColumn(nullable = false)
  private Employee employee;

  @ManyToMany
  @Column(nullable = false)
  private List<WashService> washServices;

  @Column(nullable = false)
  private LocalDateTime time;

  @Column(name = "totalprice")
  private float totalPrice;
}
