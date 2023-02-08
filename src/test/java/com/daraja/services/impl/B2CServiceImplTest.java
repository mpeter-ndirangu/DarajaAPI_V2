package com.daraja.services.impl;

import static org.mockito.Mockito.when;

import com.daraja.config.DarajaConfiguration;
import com.daraja.exceptions.DarajaExceptions;
import com.daraja.payloads.request.PaymentRequest;
import com.daraja.payloads.response.DarajaResponse;
import com.daraja.services.interfaces.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class B2CServiceImplTest {

  private B2CServiceImpl b2CService;

  @Mock
  private AuthenticationService authenticationService;

  @Mock
  private DarajaConfiguration configuration;

  @Mock
  private RestTemplate restTemplate;

  @BeforeEach
  void setUp() {
    //b2CService = new B2CServiceImpl(authenticationService, loanApplicationRepository, configuration, restTemplate);
  }

  @Test
  public void testInitiatePayment_Success() throws DarajaExceptions {
    PaymentRequest paymentRequest = new PaymentRequest();
    paymentRequest.setAmount(100F);
    paymentRequest.setMobileNumber(254712345678L);
    paymentRequest.setNarration("Test Payment");

    when(configuration.getShortCode()).thenReturn(600000); 
    when(configuration.getB2cInitiatorName()).thenReturn("testinitiator");
    when(configuration.getB2cInitiatorPassword())
        .thenReturn("testinitiatorpassword");
    when(configuration.getB2cQueueTimeoutUrl()).thenReturn("http://localhost:8080/queue");
    when(configuration.getB2cResultUrl()).thenReturn("http://localhost:8080/result");
    when(configuration.getB2cTransactionEndpoint())
        .thenReturn("https://sandbox.daraja.com/mpesa/b2c/v1/paymentrequest");
    when(authenticationService.accessToken().getAccessToken()).thenReturn("ACCESS_TOKEN");

    DarajaResponse expectedResponse = new DarajaResponse();
    expectedResponse.setResponseDescription("Success. Request accepted for processing");
    expectedResponse.setResponseCode("0");

  }
}