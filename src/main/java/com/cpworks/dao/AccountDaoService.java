package com.cpworks.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountDaoService {

  @Autowired
  private AccountDaoRepository accountDaoRepository;

  public void register(String email, String pasword) {

    AccountDao accountDao = AccountDao.builder()
        .email(email)
        .password(pasword)
        .build();
    accountDaoRepository.save(accountDao);
  }
}
