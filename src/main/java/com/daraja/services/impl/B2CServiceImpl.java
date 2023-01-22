package com.daraja.services.impl;

import com.daraja.payloads.request.B2CPaymentRequest;
import com.daraja.payloads.request.PaymentRequest;
import com.daraja.services.interfaces.AuthenticationService;
import com.daraja.services.interfaces.B2CService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class B2CServiceImpl implements B2CService {

  private final AuthenticationService authenticationService;

  public B2CServiceImpl(AuthenticationService authenticationService) {
    this.authenticationService = authenticationService;
  }
  @Value("${daraja.baseUrl}")
  public String baseUrl;

  @Value("${daraja.initiatorName}")
  public String initiatorName;

  @Value("${daraja.securityCredential}")
  public String securityCredential;

  @Value("${daraja.listenerBase}")
  public String ListenerBase ;


  @Override
  public ResponseEntity<?> initiatePayment(PaymentRequest paymentRequest) {
    return null;
  }
}
