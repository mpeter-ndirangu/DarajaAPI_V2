package com.daraja.config;

import com.daraja.entities.LoanApplication;
import com.daraja.exceptions.DarajaExceptions;
import com.daraja.payloads.request.PaymentRequest;
import com.daraja.payloads.response.DarajaResponse;
import com.daraja.services.interfaces.B2CService;
import com.daraja.services.interfaces.LoanApplicationService;
import com.google.gson.Gson;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

  private final LoanApplicationService loanApplicationService;
  private final B2CService b2CService;
  private final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);
  private final Gson gson;

  public ScheduledTasks(LoanApplicationService loanApplicationService, B2CService b2CService,
      Gson gson) {
    this.loanApplicationService = loanApplicationService;
    this.b2CService = b2CService;
    this.gson = gson;
  }

  @Scheduled(fixedRate = 10000)
  public void performTask() throws Exception {

    List<LoanApplication> loanApplicationList = loanApplicationService.getPendingLoans(1);

    for (int i = 0; i < loanApplicationList.size(); i++) {
      DarajaResponse darajaResponse;
      LoanApplication loanApplication = loanApplicationList.get(i);

      PaymentRequest paymentRequest = new PaymentRequest();
      paymentRequest.setNarration(loanApplication.getRefNo());
      paymentRequest.setAmount(loanApplication.getDisbursedAmount());
      paymentRequest.setMobileNumber(loanApplication.getPhoneNumber());
      logger.info("===============initiate Payment=============");
      logger.info(gson.toJson(paymentRequest));
      darajaResponse = b2CService.initiatePayment(paymentRequest);
      logger.info("===============Payment Response=============");
      logger.info(gson.toJson(darajaResponse));
     String msg = loanApplicationService.updateInitiatePayment(0,
          loanApplication.getRefNo(),
          darajaResponse.getConversationID(),
          darajaResponse.getOriginatorConversationID(),
          darajaResponse.getResponseCode(),
          darajaResponse.getResponseDescription());

      logger.info("===============updateInitiatePayment Response=============");
      logger.info(gson.toJson(msg));
    }

  }
}
