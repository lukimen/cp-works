package com.cpworks.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountDaoRepository extends MongoRepository<AccountDao, String> {

  AccountDao findByEmailAndPasswordAndIsDeleted(
      String email, String password, int isDeleted);
}
