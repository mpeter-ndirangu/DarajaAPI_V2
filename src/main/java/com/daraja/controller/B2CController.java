package com.daraja.controller;

import com.daraja.payloads.request.PaymentRequest;
import com.daraja.services.interfaces.B2CService;
import java.math.BigDecimal;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class B2CController {

  private  final B2CService b2CService;


  public B2CController(B2CService b2CService) {
    this.b2CService = b2CService;
  }

  @GetMapping("/payment")
  ResponseEntity<?> initiatePayment() {
    PaymentRequest paymentRequest = new PaymentRequest();
    paymentRequest.setAmount(100F);
    paymentRequest.setNarration("Loan");
    paymentRequest.setMobileNumber(254708374149L);
    paymentRequest.setCommandID("");
    b2CService.initiatePayment(paymentRequest);
    return ResponseEntity.ok("Payment Initiated");
  }
}
