package com.cpworks.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDaoService {

  @Autowired
  private AccountDaoRepository accountDaoRepository;

  public void register(String email, String pasword) {

    //buat object account
    AccountDao accountDao = AccountDao.builder()
        .email(email)
        .password(pasword)
        .build();
    accountDaoRepository.save(accountDao);
  }

  public boolean login(String email, String pasword) {

    //cari pake email & password
    AccountDao accountDao =
        accountDaoRepository.findByEmailAndPasswordAndIsDeleted(email, pasword, 0);

    if (accountDao == null){
      return false; //kalo null user ga ada balikin false
    }

    //user ada balikin true
    return true;
  }
}
