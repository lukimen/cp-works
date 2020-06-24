package com.cpworks.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        .filter(orderDao -> Objects.isNull(orderDao.getEmail())) //filter kalo data ga ada
        .collect(Collectors.toList()); //balikin list hasil
  }
}
