package com.daraja.services.impl;

import com.daraja.entities.LoanApplication;
import com.daraja.repos.LoanApplicationRepository;
import com.daraja.services.interfaces.LoanApplicationService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class LoanApplicationServiceImpl implements LoanApplicationService {

  private final LoanApplicationRepository loanApplicationRepository;

  public LoanApplicationServiceImpl(LoanApplicationRepository loanApplicationRepository) {
    this.loanApplicationRepository = loanApplicationRepository;
  }

  @Override
  public List<LoanApplication> getPendingLoans(Integer flg) {
    return loanApplicationRepository.getPendingLoans(1);
  }
}
