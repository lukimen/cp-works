package com.cpworks.dao;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class LaporanDetail implements Serializable {
  private String deskripsi;
  private double total;
}
