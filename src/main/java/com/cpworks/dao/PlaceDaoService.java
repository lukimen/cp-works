package com.cpworks.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class PlaceDaoService {

  @Autowired
  private PlaceDaoRepository placeDaoRepository;

  public List<PlaceDao> findByType(String placeType) {
    return placeDaoRepository.findByPlaceTypeAndIsDeleted(placeType, 0) //query pake type
        .stream()
        .filter(orderDao -> Objects.nonNull(orderDao.getName())) //filter kalo data ga ada
        .collect(Collectors.toList()); //balikin list hasil
  }

  public boolean addPlace(
      String placeType,
      String name,
      String address,
      String address2,
      String image,
      String durasi,
      double price,
      double latitude,
      double longitude) {

    PlaceDao placeDao = PlaceDao.builder()
        .placeType(placeType.toLowerCase()) //pake lower case biar gampang
        .name(name)
        .address(address)
        .address2(address2)
        .image(image)
        .durasi(durasi.toLowerCase())  //pake lower case biar gampang
        .price(price)
        .latitude(latitude)
        .longitude(longitude)
        .build();

    placeDaoRepository.save(placeDao);

    return true;
  }
}
