package com.daraja.payloads.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class B2CPaymentRequest {
  @JsonProperty("InitiatorName")
  private String InitiatorName;
  @JsonProperty("SecurityCredential")
  private String SecurityCredential;
  @JsonProperty("CommandID")
  private String CommandID;
  @JsonProperty("Amount")
  private Float Amount;
  @JsonProperty("PartyA")
  private Integer PartyA;
  @JsonProperty("PartyB")
  private Long PartyB;
  @JsonProperty("Remarks")
  private String Remarks;
  @JsonProperty("QueueTimeOutURL")
  private String QueueTimeOutURL;
  @JsonProperty("ResultURL")
  private String ResultURL;
  @JsonProperty("Occassion")
  private String Occassion;

  public B2CPaymentRequest() {
  }

  public String getInitiatorName() {
    return InitiatorName;
  }

  public void setInitiatorName(String initiatorName) {
    InitiatorName = initiatorName;
  }

  public String getSecurityCredential() {
    return SecurityCredential;
  }

  public void setSecurityCredential(String securityCredential) {
    SecurityCredential = securityCredential;
  }

  public String getCommandID() {
    return CommandID;
  }

  public void setCommandID(String commandID) {
    CommandID = commandID;
  }

  public Float getAmount() {
    return Amount;
  }

  public void setAmount(Float amount) {
    Amount = amount;
  }

  public Integer getPartyA() {
    return PartyA;
  }

  public void setPartyA(Integer partyA) {
    PartyA = partyA;
  }

  public Long getPartyB() {
    return PartyB;
  }

  public void setPartyB(Long partyB) {
    PartyB = partyB;
  }

  public String getRemarks() {
    return Remarks;
  }

  public void setRemarks(String remarks) {
    Remarks = remarks;
  }

  public String getQueueTimeOutURL() {
    return QueueTimeOutURL;
  }

  public void setQueueTimeOutURL(String queueTimeOutURL) {
    QueueTimeOutURL = queueTimeOutURL;
  }

  public String getResultURL() {
    return ResultURL;
  }

  public void setResultURL(String resultURL) {
    ResultURL = resultURL;
  }

  public String getOccassion() {
    return Occassion;
  }

  public void setOccassion(String occassion) {
    Occassion = occassion;
  }
}
