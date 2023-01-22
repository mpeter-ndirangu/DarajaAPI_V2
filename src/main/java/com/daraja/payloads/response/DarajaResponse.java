package com.daraja.payloads.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DarajaResponse {

  @JsonProperty("ConversationID")
  private String conversationID;
  @JsonProperty("OriginatorConversationID")
  private String originatorConversationID;
  @JsonProperty("ResponseCode")
  private String responseCode;
  @JsonProperty("ResponseDescription")
  private String responseDescription;

  public DarajaResponse() {
  }

  public String getConversationID() {
    return conversationID;
  }

  public void setConversationID(String conversationID) {
    this.conversationID = conversationID;
  }

  public String getOriginatorConversationID() {
    return originatorConversationID;
  }

  public void setOriginatorConversationID(String originatorConversationID) {
    this.originatorConversationID = originatorConversationID;
  }

  public String getResponseCode() {
    return responseCode;
  }

  public void setResponseCode(String responseCode) {
    this.responseCode = responseCode;
  }

  public String getResponseDescription() {
    return responseDescription;
  }

  public void setResponseDescription(String responseDescription) {
    this.responseDescription = responseDescription;
  }
}
