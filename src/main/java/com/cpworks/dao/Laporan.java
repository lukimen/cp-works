package com.cpworks.dao;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class Laporan implements Serializable {
  private List<LaporanDetail> laporanDetails;
  private double total;
}
