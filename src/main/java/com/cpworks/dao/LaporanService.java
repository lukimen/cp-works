package com.cpworks.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class LaporanService {



  @Autowired
  private OrderDaoRepository orderDaoRepository;

  public Laporan getLaporanBulanan(
      String tahunAwal, //cth: 2020
      String bulanAwal, //cth: 1
      String tahunAkhir, //cth: 2022
      String bulanAkhir //cth: 5
  ) {

    if (bulanAwal.length()==1){ //format buat bulan yg 1 digit
      bulanAwal = "0" + bulanAwal;
    }

    if (bulanAkhir.length()==1){ //format buat bulan yg 1 digit
      bulanAkhir = "0" + bulanAwal;
    }

    String awalTgl = "01";

    //format tgl awal & akhir
    Date startDate = DateFormatterHelper.stringToDate(tahunAwal+"-"+bulanAwal+"-"+awalTgl);
    Date endDate = DateFormatterHelper.stringToDate(tahunAkhir+"-"+bulanAkhir+"-"+awalTgl);

    //data default
    List<LaporanDetail> laporanDetails = new ArrayList<>();
    double total = 0;

    //cari di database
    List<OrderDao> laporanDB = orderDaoRepository
        .findByIsDeletedAndTanggalAwalSewaBetween(0, startDate, endDate);


    //looping buat data laporan
    for (OrderDao orderDao: laporanDB) {

      total = total + orderDao.getTotalBayar();
      LaporanDetail laporanBulanan = formatLaporanBulanan(orderDao);
      laporanDetails.add(laporanBulanan);
    }

    //sukses
    return Laporan.builder()
        .total(total)
        .laporanDetails(laporanDetails)
        .build();
  }

  public Laporan getLaporanMingguan(
      String tahunAwal,
      String mingguAwal,
      String tahunAkhir,
      String mingguAkhir) {

    //format tgl awal & akhir
    Date startDate = DateFormatterHelper.stringToDateMinggu(tahunAwal+"-"+mingguAwal);
    Date endDate = DateFormatterHelper.stringToDateMinggu(tahunAkhir+"-"+mingguAkhir);

    //data default
    List<LaporanDetail> laporanDetails = new ArrayList<>();
    double total = 0;


    //cari di database
    List<OrderDao> laporanDB = orderDaoRepository
        .findByIsDeletedAndTanggalAwalSewaBetween(0, startDate, endDate);


    //looping buat data laporan
    for (OrderDao orderDao: laporanDB) {

      total = total + orderDao.getTotalBayar();
      LaporanDetail laporanBulanan = formatLaporanMingguan(orderDao);
      laporanDetails.add(laporanBulanan);
    }

    //sukses
    return Laporan.builder()
        .total(total)
        .laporanDetails(laporanDetails)
        .build();
  }

  private LaporanDetail formatLaporanBulanan(OrderDao orderDao){

    return LaporanDetail.builder()
        .total(orderDao.getTotalBayar())
        .deskripsi(getDeskripsiBulanan(orderDao.getTanggalAwalSewa()))
        .build();
  }

  private LaporanDetail formatLaporanMingguan(OrderDao orderDao){
    return LaporanDetail.builder()
        .total(orderDao.getTotalBayar())
        .deskripsi(getDeskripsiMingguan(orderDao.getTanggalAwalSewa()))
        .build();
  }

  private String getDeskripsiBulanan(Date date){
    String tahun = DateFormatterHelper.dateToStringTahun(date);
    String namaBulan = getNamaBulan(DateFormatterHelper.dateToStringBulan(date));
    return "- Tahun " + tahun + " bulan " + namaBulan;
  }

  private String getDeskripsiMingguan(Date date){
    String tahun = DateFormatterHelper.dateToStringTahun(date);
    String mingguKe = DateFormatterHelper.dateToStringMinggu(date);
    return "- Tahun " + tahun + " Minggu ke " + Integer.valueOf(mingguKe);
  }

  private String getNamaBulan(String bulan) {
    if ("01".equalsIgnoreCase(bulan)) {
      return "Januari";
    }
    if ("02".equalsIgnoreCase(bulan)) {
      return "Februari";
    }
    if ("03".equalsIgnoreCase(bulan)) {
      return "Maret";
    }
    if ("04".equalsIgnoreCase(bulan)) {
      return "April";
    }
    if ("05".equalsIgnoreCase(bulan)) {
      return "Mei";
    }
    if ("06".equalsIgnoreCase(bulan)) {
      return "Juni";
    }
    if ("07".equalsIgnoreCase(bulan)) {
      return "Juli";
    }
    if ("08".equalsIgnoreCase(bulan)) {
      return "Agustus";
    }
    if ("09".equalsIgnoreCase(bulan)) {
      return "September";
    }
    if ("10".equalsIgnoreCase(bulan)) {
      return "Oktober";
    }
    if ("11".equalsIgnoreCase(bulan)) {
      return "November";
    }

    return "Desember";
  }
}
