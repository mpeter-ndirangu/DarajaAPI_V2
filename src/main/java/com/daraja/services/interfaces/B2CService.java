package com.daraja.services.interfaces;

import com.daraja.exceptions.DarajaExceptions;
import com.daraja.payloads.request.PaymentRequest;
import org.springframework.http.ResponseEntity;

public interface B2CService {

  ResponseEntity<?> initiatePayment(PaymentRequest paymentRequest) throws DarajaExceptions;

}
