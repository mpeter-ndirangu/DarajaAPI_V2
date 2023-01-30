package com.daraja.payloads.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
public class ResultParameters {
  @JsonProperty("ResultParameter")
  private List<ResultParametersItem> parametersItems;

}
