package com.daraja.util;

import java.io.IOException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Base64;
import java.security.*;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class PasswordUtil {

  public static String b64Encode(String pString) {
    byte[] bytes = Base64.getEncoder().encode(pString.getBytes());
    return new String(bytes);
  }

  public static String getSecurityCredentials(String initiatorPassword) {
    String encryptedPassword;
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
      throw new RuntimeException(e);
    } catch (NoSuchPaddingException e) {
      throw new RuntimeException(e);
    } catch (NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    } catch (NoSuchProviderException e) {
      throw new RuntimeException(e);
    } catch (CertificateException e) {
      throw new RuntimeException(e);
    } catch (InvalidKeyException e) {
      throw new RuntimeException(e);
    } catch (IllegalBlockSizeException e) {
      throw new RuntimeException(e);
    } catch (BadPaddingException e) {
      throw new RuntimeException(e);
    }
  }
}
