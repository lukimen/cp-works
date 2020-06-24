package com.cpworks.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlaceDaoRepository extends MongoRepository<PlaceDao, String> {

  List<PlaceDao> findByPlaceTypeAndIsDeleted(
      String type, int isDeleted);
}
