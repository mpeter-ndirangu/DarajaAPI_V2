package com.daraja.services.impl;

import com.daraja.payloads.response.AccessTokenResponse;
import com.daraja.services.interfaces.AuthenticationService;
import com.daraja.util.PasswordUtil;
import java.util.Base64;
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
public class AuthenticationServiceImpl implements AuthenticationService {

  private static final Logger logger = LoggerFactory.getLogger(AuthenticationServiceImpl.class);
  private final RestTemplate restTemplate;

  public AuthenticationServiceImpl(RestTemplate restTemplate) {
    this.restTemplate = restTemplate;
  }

  @Value("${daraja.consumerKey}")
  public String consumerKey;

  @Value("${daraja.consumerSecret}")
  public String consumerSecret;

  @Value("${daraja.baseUrl}")
  public String baseUrl;

  @Override
  public AccessTokenResponse accessToken() {
    AccessTokenResponse tokenResponse = null;
    try {
      //Encode Key and secret to base64
      String encodedString = PasswordUtil.b64Encode(consumerKey + ":" + consumerSecret);
      // setting up the request headers
      HttpHeaders requestHeaders = new HttpHeaders();
      requestHeaders.add("Authorization", "Basic " + encodedString);
      requestHeaders.add("cache-control", "no-cache");
      HttpEntity<String> request = new HttpEntity<>(requestHeaders);
      ResponseEntity<AccessTokenResponse> responseEntity = restTemplate.exchange(
          baseUrl + "/oauth/v1/generate?grant_type=client_credentials",
          HttpMethod.GET, request, AccessTokenResponse.class);

      if (responseEntity.getStatusCode() == HttpStatus.OK) {
        tokenResponse = responseEntity.getBody();
      }
    } catch (Exception ex) {
      logger.error("Error getting access Token", ex);
    }
    return tokenResponse;
  }
}
