package com.cpworks.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class BaseResponse<T> implements Serializable {
  private String code;
  private String message;
  private List<String> errors;
  private T data;
}
