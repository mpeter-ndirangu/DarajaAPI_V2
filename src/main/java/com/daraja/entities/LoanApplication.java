package com.daraja.entities;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;

@Entity
@Data
public class LoanApplication {
  @Id
  @Column
  private long id;
  @Column
  private Long phoneNumber;
  @Column
  private String refNo;
  @Column
  private Float disbursedAmount;
  @Column
  private String accountReferenceNumber;
  @Column
  private String shortCode;
}
