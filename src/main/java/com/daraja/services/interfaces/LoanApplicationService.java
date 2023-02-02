package com.daraja.services.interfaces;

import com.daraja.entities.LoanApplication;
import java.util.List;
import org.springframework.data.repository.query.Param;


public interface LoanApplicationService {
  List<LoanApplication> getPendingLoans(Integer flg);
}
