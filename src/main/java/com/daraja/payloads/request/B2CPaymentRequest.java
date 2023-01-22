package com.daraja.payloads.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class B2CPaymentRequest {
  @JsonProperty("InitiatorName")
  private String initiatorName;
  @JsonProperty("SecurityCredential")
  private String securityCredential;
  @JsonProperty("CommandID")
  private String commandID;
  @JsonProperty("Amount")
  private String amount;
  @JsonProperty("PartyA")
  private String partyA;
  @JsonProperty("PartyB")
  private String partyB;
  @JsonProperty("Remarks")
  private String remarks;
  @JsonProperty("QueueTimeOutURL")
  private String queueTimeOutURL;
  @JsonProperty("ResultURL")
  private String resultURL;
  @JsonProperty("Occasion")
  private String occasion;

  public B2CPaymentRequest() {
  }

  public String getInitiatorName() {
    return initiatorName;
  }

  public void setInitiatorName(String initiatorName) {
    this.initiatorName = initiatorName;
  }

  public String getSecurityCredential() {
    return securityCredential;
  }

  public void setSecurityCredential(String securityCredential) {
    this.securityCredential = securityCredential;
  }

  public String getCommandID() {
    return commandID;
  }

  public void setCommandID(String commandID) {
    this.commandID = commandID;
  }

  public String getAmount() {
    return amount;
  }

  public void setAmount(String amount) {
    this.amount = amount;
  }

  public String getPartyA() {
    return partyA;
  }

  public void setPartyA(String partyA) {
    this.partyA = partyA;
  }

  public String getPartyB() {
    return partyB;
  }

  public void setPartyB(String partyB) {
    this.partyB = partyB;
  }

  public String getRemarks() {
    return remarks;
  }

  public void setRemarks(String remarks) {
    this.remarks = remarks;
  }

  public String getQueueTimeOutURL() {
    return queueTimeOutURL;
  }

  public void setQueueTimeOutURL(String queueTimeOutURL) {
    this.queueTimeOutURL = queueTimeOutURL;
  }

  public String getResultURL() {
    return resultURL;
  }

  public void setResultURL(String resultURL) {
    this.resultURL = resultURL;
  }

  public String getOccasion() {
    return occasion;
  }

  public void setOccasion(String occasion) {
    this.occasion = occasion;
  }
}
