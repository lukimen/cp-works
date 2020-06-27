package com.cpworks.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class OrderDaoService {

  @Autowired
  private OrderDaoRepository orderDaoRepository;

  public List<OrderDao> getOrder(String email) {
 
    return orderDaoRepository.findByEmailAndIsDeleted(email, 0) //query pake email
        .stream()
        .filter(orderDao -> Objects.nonNull(orderDao.getEmail())) //filter kalo data ga ada
        .collect(Collectors.toList()); //balikin list hasil
  }

  public boolean pesan(
      String placeId,
      String tanggalAwalSewa,
      String email,
      int durasiSewa,
      double totalBayar) {

    //construct object pesanan
    OrderDao orderDao = OrderDao.builder()
        .placeId(placeId)
        .tanggalAwalSewa(DateFormatterHelper.stringToDate(tanggalAwalSewa))
        .email(email)
        .durasiSewa(durasiSewa)
        .totalBayar(totalBayar)
        .build();

    // input pesanan
    orderDaoRepository.save(orderDao);

    //sukses
    return true;
  }
}
