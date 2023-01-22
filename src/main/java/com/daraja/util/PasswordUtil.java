package com.daraja.util;

import java.util.Base64;

public class PasswordUtil {

  public static String b64Encode(String pString) {
    byte[] b64ytes = Base64.getEncoder().encode(pString.getBytes());
    return new String(b64ytes);
  }
}
