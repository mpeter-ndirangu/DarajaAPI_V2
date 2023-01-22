package com.daraja.controller;

import com.daraja.services.interfaces.AuthenticationService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class B2CController {

  private  final AuthenticationService authenticationService;

  public B2CController(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }


}
