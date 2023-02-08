package com.daraja.services.impl;

import com.daraja.config.DarajaConfiguration;
import com.daraja.payloads.response.AccessTokenResponse;
import com.daraja.services.interfaces.AuthenticationService;
import com.daraja.util.PasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
  private final DarajaConfiguration configuration;


  public AuthenticationServiceImpl(RestTemplate restTemplate, DarajaConfiguration configuration) {
    this.restTemplate = restTemplate;
    this.configuration = configuration;
  }


  @Override
  public AccessTokenResponse accessToken() {
    AccessTokenResponse tokenResponse = null;
    try {
      //Encode Key and secret to base64
      String encodedString = PasswordUtil.b64Encode(
          configuration.getConsumerKey() + ":" + configuration.getConsumerSecret());
      // setting up the request headers
      HttpHeaders requestHeaders = new HttpHeaders();
      requestHeaders.add("Authorization", "Basic " + encodedString);
      requestHeaders.add("cache-control", "no-cache");
      HttpEntity<String> request = new HttpEntity<>(requestHeaders);
      ResponseEntity<AccessTokenResponse> responseEntity = restTemplate.exchange(
          configuration.getOauthEndpoint(), HttpMethod.GET, request, AccessTokenResponse.class);

      if (responseEntity.getStatusCode() == HttpStatus.OK) {
        tokenResponse = responseEntity.getBody();
      }
    } catch (Exception ex) {
      logger.error("Error getting access Token", ex);
    }
    return tokenResponse;
  }
}
