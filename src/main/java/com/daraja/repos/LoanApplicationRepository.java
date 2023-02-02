package com.daraja.repos;

import com.daraja.entities.LoanApplication;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
//  @Query(value = "select id, PhoneNumber as phone_number, LoanNo as ref_no, DisbursedAmount as disbursed_amount,Account_Reference_Number as account_reference_number," +
//      " BuyGoods_No as short_code from dbo.LoanApplications where Disburse_Mode= 1 and DisburseDate is null", nativeQuery = true)

 // @Query(value = "CALL mpesa_b2c_fetchrecords(?)", nativeQuery = true)
 // @Procedure(value = "mpesa_b2c_fetchrecords" )
 @Query(value = "{CALL mpesa_b2c_fetchrecords(:flg)};", nativeQuery = true)
  List<LoanApplication> getPendingLoans(@Param("flg") Integer flg);
}
