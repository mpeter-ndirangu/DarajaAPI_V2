package com.daraja.payloads.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class PaymentRequest {

  @JsonProperty("CommandID")
  private String commandID;

  @JsonProperty("Amount")
  private BigDecimal amount;

  @JsonProperty("Shortcode")
  private String shortcode;

  @JsonProperty("MobileNumber")
  private String mobileNumber;

  @JsonProperty("Narration")
  private String narration;

  public PaymentRequest() {
  }

  public String getCommandID() {
    return commandID;
  }

  public void setCommandID(String commandID) {
    this.commandID = commandID;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  public String getShortcode() {
    return shortcode;
  }

  public void setShortcode(String shortcode) {
    this.shortcode = shortcode;
  }

  public String getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(String mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getNarration() {
    return narration;
  }

  public void setNarration(String narration) {
    this.narration = narration;
  }
}
