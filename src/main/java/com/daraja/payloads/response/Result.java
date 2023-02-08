package com.daraja.payloads.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
public class Result {

  @JsonProperty("ResultType")
  private Integer resultType;

  @JsonProperty("ResultCode")
  private Integer ResultCode;

  @JsonProperty("ResultDesc")
  private String resultDesc;

  @JsonProperty("OriginatorConversationID")
  private String OriginatorConversationID;

  @JsonProperty("ConversationID")
  private String ConversationID;

  @JsonProperty("TransactionID")
  private String transactionID;

  @JsonProperty("ResultParameters")
  private ResultParameters resultParameters;

  @JsonProperty("TransactionReceipt")
  private String transactionReceipt;

  @JsonProperty("TransactionAmount")
  private Float transactionAmount;

  @JsonProperty("B2CWorkingAccountAvailableFunds")
  private BigDecimal b2CWorkingAccountAvailableFunds;

  @JsonProperty("B2CUtilityAccountAvailableFunds")
  private BigDecimal b2CUtilityAccountAvailableFunds;

  @JsonProperty("TransactionCompletedDateTime")
  private String transactionCompletedDateTime;

  @JsonProperty("ReceiverPartyPublicName")
  private String receiverPartyPublicName;

  @JsonProperty("B2CChargesPaidAccountAvailableFunds")
  private BigDecimal b2CChargesPaidAccountAvailableFunds;

  @JsonProperty("B2CRecipientIsRegisteredCustomer")
  private String b2CRecipientIsRegisteredCustomer;
}
