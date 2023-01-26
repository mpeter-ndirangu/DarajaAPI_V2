package com.daraja.services.impl;

import com.daraja.payloads.request.B2CCommands;
import com.daraja.payloads.request.B2CPaymentRequest;
import com.daraja.payloads.request.PaymentRequest;
import com.daraja.payloads.response.DarajaResponse;
import com.daraja.services.interfaces.AuthenticationService;
import com.daraja.services.interfaces.B2CService;
import com.daraja.util.PasswordUtil;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class B2CServiceImpl implements B2CService {

  private static final Logger logger = LoggerFactory.getLogger(B2CServiceImpl.class);
  private final AuthenticationService authenticationService;

  private final RestTemplate restTemplate;

  public B2CServiceImpl(AuthenticationService authenticationService, RestTemplate restTemplate) {
    this.authenticationService = authenticationService;
    this.restTemplate = restTemplate;
  }
  @Value("${daraja.baseUrl}")
  public String baseUrl;

  @Value("${daraja.initiatorName}")
  public String initiatorName;

  @Value("${daraja.initiatorPassword}")
  public String initiatorPassword;


  @Value("${daraja.listenerBase}")
  public String ListenerBase ;

  @Value("${daraja.senderShortCode}")
  public Integer senderShortCode ;



  @Override
  public ResponseEntity<?> initiatePayment(PaymentRequest paymentRequest) {
    DarajaResponse darajaResponse = new DarajaResponse();
    try {

      HttpHeaders requestHeaders = new HttpHeaders();
      requestHeaders.add("Authorization", "Bearer " + authenticationService.accessToken().getAccessToken());
      requestHeaders.add("cache-control", "no-cache");
      requestHeaders.add("Content-Type", "application/json");
      B2CPaymentRequest b2CPaymentRequest = new B2CPaymentRequest();
      b2CPaymentRequest.setInitiatorName(initiatorName);
      b2CPaymentRequest.setSecurityCredential(PasswordUtil.getSecurityCredentials(initiatorPassword));
      b2CPaymentRequest.setCommandID(B2CCommands.BusinessPayment.name());
      b2CPaymentRequest.setAmount(paymentRequest.getAmount());
      b2CPaymentRequest.setPartyA(senderShortCode);
      b2CPaymentRequest.setPartyB(paymentRequest.getMobileNumber());
      b2CPaymentRequest.setRemarks(paymentRequest.getNarration());
      b2CPaymentRequest.setQueueTimeOutURL("https://mydomain.com/b2c/queue");
      b2CPaymentRequest.setResultURL("https://mydomain.com/b2c/result");
      b2CPaymentRequest.setOccassion(paymentRequest.getNarration());

      Gson gson = new Gson();
      String payload = gson.toJson(b2CPaymentRequest);

      HttpEntity<String> request = new HttpEntity<>(payload, requestHeaders );
      ResponseEntity<DarajaResponse> responseEntity = restTemplate.exchange(baseUrl + "/mpesa/b2c/v1/paymentrequest",
          HttpMethod.POST, request, DarajaResponse.class);
      if (responseEntity.getStatusCode() == HttpStatus.OK){
        darajaResponse = responseEntity.getBody(); 
        return null;
      }

    } catch (Exception ex) {
      logger.error("Error sending b2c", ex);
      return null;
    }
    return null;
  }
}
