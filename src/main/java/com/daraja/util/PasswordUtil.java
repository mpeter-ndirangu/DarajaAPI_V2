package com.daraja.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PasswordUtil {

  private static final Logger logger =  LoggerFactory.getLogger(PasswordUtil.class);

  public static String b64Encode(String pString) {
    byte[] bytes = Base64.getEncoder().encode(pString.getBytes());
    return new String(bytes);
  }

  public static String getSecurityCredentials(String initiatorPassword) {
    String encryptedPassword = "";
    try {
      Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
      byte[]  input = initiatorPassword.getBytes();

      Resource resource = new ClassPathResource("cert.cer");
      InputStream inputStream = resource.getInputStream();
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding", "BC");
      CertificateFactory cf = CertificateFactory.getInstance("X.509");
      X509Certificate certificate =(X509Certificate) cf.generateCertificate(inputStream);
      PublicKey pk = certificate.getPublicKey();
      cipher.init(Cipher.ENCRYPT_MODE, pk);
      byte[] cipherText = cipher.doFinal(input);
      encryptedPassword = String.valueOf(Base64.getEncoder().encode(cipherText));
      return encryptedPassword;
    } catch (IOException e) {
      logger.error("getSecurityCredentials RuntimeException ", e);
      throw new RuntimeException(e);
    } catch (NoSuchPaddingException e) {
      logger.error("getSecurityCredentials NoSuchPaddingException ", e);
      throw new RuntimeException(e);
    } catch (NoSuchAlgorithmException e) {
      logger.error("getSecurityCredentials NoSuchAlgorithmException ", e);
      throw new RuntimeException(e);
    } catch (NoSuchProviderException e) {
      logger.error("getSecurityCredentials NoSuchProviderException ", e);
      throw new RuntimeException(e);
    } catch (CertificateException e) {
      logger.error("getSecurityCredentials CertificateException ", e);
      throw new RuntimeException(e);
    } catch (InvalidKeyException e) {
      logger.error("getSecurityCredentials InvalidKeyException ", e);
      throw new RuntimeException(e);
    } catch (IllegalBlockSizeException e) {
      logger.error("getSecurityCredentials IllegalBlockSizeException ", e);
      throw new RuntimeException(e);
    } catch (BadPaddingException e) {
      logger.error("getSecurityCredentials BadPaddingException ", e);
      throw new RuntimeException(e);
    }
  }
}
