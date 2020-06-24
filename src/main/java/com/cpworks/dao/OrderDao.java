package com.cpworks.dao;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Builder
public class OrderDao implements Serializable {
  @Id
  @Field("_id")
  private String id;
  private String placeId;
  private String tglAwalSewa;
  private int durasiSewa;
  private String email;
  private double totalBayar;
  private int isDeleted;
}
