package com.daraja.payloads.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PaymentRequest {

  @JsonProperty("CommandID")
  private String commandID;

  @JsonProperty("Amount")
  private Float amount;
  @JsonProperty("MobileNumber")
  private Long mobileNumber;

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


  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public Long getMobileNumber() {
    return mobileNumber;
  }

  public void setMobileNumber(Long mobileNumber) {
    this.mobileNumber = mobileNumber;
  }

  public String getNarration() {
    return narration;
  }

  public void setNarration(String narration) {
    this.narration = narration;
  }
}
