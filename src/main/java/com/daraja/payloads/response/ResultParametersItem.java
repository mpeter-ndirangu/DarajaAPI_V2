package com.daraja.payloads.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResultParametersItem {

  @JsonProperty("Value")
  private String value;

  @JsonProperty("Key")
  private String key;

}
