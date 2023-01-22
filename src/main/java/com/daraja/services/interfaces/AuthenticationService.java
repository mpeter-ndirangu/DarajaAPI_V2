package com.daraja.services.interfaces;

import com.daraja.payloads.response.AccessTokenResponse;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {

  AccessTokenResponse accessToken();
}
