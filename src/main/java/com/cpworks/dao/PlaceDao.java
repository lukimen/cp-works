package com.cpworks.dao;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Builder
public class PlaceDao implements Serializable {
  @Id
  @Field("_id")
  private String id;
  private double latitude;
  private double longitude;
  private double price;
  private String placeType;
  private String name;
  private String address;
  private String address2;
  private String durasi;
  private String ukuran;
  private String image;
  private int isDeleted;
}
