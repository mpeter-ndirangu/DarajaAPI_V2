package com.daraja.controller;

import com.daraja.exceptions.DarajaExceptions;
import com.daraja.payloads.request.PaymentRequest;
import com.daraja.payloads.response.AcknowledgeResponse;
import com.daraja.payloads.response.B2CTransactionAsyncResponse;
import com.daraja.services.interfaces.B2CService;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class B2CController {

  private final Logger logger = LoggerFactory.getLogger(B2CController.class);
  private final Gson gson;
  private final B2CService b2CService;


  public B2CController(Gson gson, B2CService b2CService) {
    this.gson = gson;
    this.b2CService = b2CService;
  }

  @RequestMapping(value = "/payment", method = RequestMethod.POST, produces = "application/json")
  ResponseEntity<?> initiatePayment(@RequestBody PaymentRequest paymentRequest)
      throws Exception {
    logger.info("===============initiate Payment=============");
    logger.info(gson.toJson(paymentRequest));
    return ResponseEntity.ok(b2CService.initiatePayment(paymentRequest));
  }

  @RequestMapping(value = "/transaction-result", method = RequestMethod.POST, produces = "application/json")
  ResponseEntity<?> b2cTransactionAsyncResults(@RequestBody
  B2CTransactionAsyncResponse b2CTransactionAsyncResponse) {
    logger.info("===============Transaction Result=============");
    logger.info(gson.toJson(b2CTransactionAsyncResponse));
    return b2CService.b2cTransactionAsyncResults(b2CTransactionAsyncResponse);
  }

  @RequestMapping(value = "/b2c-queue-timeout", method = RequestMethod.POST, produces = "application/json")
  ResponseEntity<?> b2cQueueTimeout(@RequestBody
  B2CTransactionAsyncResponse b2CTransactionAsyncResponse) {
    logger.info("===============Queue-Timeout=============");
    logger.info(gson.toJson(b2CTransactionAsyncResponse));
    return b2CService.b2cTransactionAsyncResults(b2CTransactionAsyncResponse);
  }
}
