package com.daraja.controller;

import com.daraja.exceptions.DarajaExceptions;
import com.daraja.payloads.request.PaymentRequest;
import com.daraja.services.interfaces.B2CService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class B2CController {

  private final B2CService b2CService;


  public B2CController(B2CService b2CService) {
    this.b2CService = b2CService;
  }

 @RequestMapping(value = "/payment", method = RequestMethod.POST , produces = "application/json")
  ResponseEntity<?> initiatePayment(@RequestBody PaymentRequest paymentRequest)
      throws DarajaExceptions {
    return b2CService.initiatePayment(paymentRequest);
  }
}
