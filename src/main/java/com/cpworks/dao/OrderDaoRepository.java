package com.cpworks.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface OrderDaoRepository extends MongoRepository<OrderDao, String> {

  List<OrderDao> findByEmailAndIsDeleted(
      String email, int isDeleted);

  List<OrderDao> findByIsDeletedAndTanggalAwalSewaBetween(
      int isDeleted, Date starDate, Date endDate);
}
