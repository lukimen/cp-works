package com.cpworks.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PlaceDaoService {

  @Autowired
  private PlaceDaoRepository placeDaoRepository;

  public List<PlaceDao> findByType(String type) {
    return placeDaoRepository.findByPlaceTypeAndIsDeleted(type, 0) //query pake type
        .stream()
        .filter(orderDao -> Objects.isNull(orderDao.getName())) //filter kalo data ga ada
        .collect(Collectors.toList()); //balikin list hasil
  }
}
