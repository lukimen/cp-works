package com.cpworks.model;

public enum ResponseCode {
  SUCCESS("SUKSES", "SUKSES"),
  SYSTEM_ERROR("SYSTEM_ERROR", "Contact Tim Kita"),
  DATA_NOT_EXIST("DATA_TIDAK_ADA", "data tidak ada"),
  DATA_NOT_VALID("DATA_TIDAK_VALID", "data tidak valid");

  private String code;
  private String message;

  ResponseCode(String code, String message) {
    this.code = code;
    this.message = message;
  }

  public String getCode() {
    return code;
  }

  public String getMessage() {
    return message;
  }
}
