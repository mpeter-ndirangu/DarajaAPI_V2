package com.daraja.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "mpesa.daraja")
public class DarajaConfiguration {
  private String consumerKey;
  private String consumerSecret;
  private String oauthEndpoint;
  private String registerUrlEndpoint;
  private String simulateTransactionEndpoint;
  private Integer shortCode;
  private String confirmationURL;
  private String validationURL;
  private String responseType;
  private String b2cTransactionEndpoint;
  private String b2cResultUrl;
  private String b2cQueueTimeoutUrl;
  private String b2cInitiatorName;
  private String b2cInitiatorPassword;
//  private String transactionResultUrl;
//  private String checkAccountBalanceUrl;
//  private String stkPassKey;
//  private String stkPushShortCode;
//  private String stkPushRequestUrl;
//  private String stkPushRequestCallbackUrl;
//  private String lnmQueryRequestUrl;
}
