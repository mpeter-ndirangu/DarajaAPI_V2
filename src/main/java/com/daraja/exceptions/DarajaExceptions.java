package com.daraja.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DarajaExceptions extends Exception{

  public DarajaExceptions(String message) {
    super(message);
  }

}
