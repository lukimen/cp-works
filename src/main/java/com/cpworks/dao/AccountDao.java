package com.cpworks.dao;


import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;

@Data
@Builder
public class AccountDao implements Serializable {
  @Id
  @Field("_id")
  private String id;
  private int isDeleted;
  private String email;
  private String password;
}
