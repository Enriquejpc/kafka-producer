package com.producer.kafka.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Liquidation implements Serializable {

  private Integer establishmentId;
  private Integer brandCode;
  private String brand;
  private String day;
  private Double grossTotal;
  private Double tariffsAndFinancialExpensesTotal;
  private Double taxesTotal;
  private Double netTotal;

}
