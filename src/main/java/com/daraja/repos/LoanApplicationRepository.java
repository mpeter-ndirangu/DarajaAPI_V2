package com.daraja.repos;

import com.daraja.entities.LoanApplication;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {
//  @Query(value = "select id, PhoneNumber as phone_number, LoanNo as ref_no, DisbursedAmount as disbursed_amount,Account_Reference_Number as account_reference_number," +
//      " BuyGoods_No as short_code from dbo.LoanApplications where Disburse_Mode= 1 and DisburseDate is null", nativeQuery = true)

  // @Query(value = "CALL mpesa_b2c_fetchrecords(?)", nativeQuery = true)
  // @Procedure(value = "mpesa_b2c_fetchrecords" )
  @Query(value = "{CALL mpesa_b2c_fetchrecords(:flg)};", nativeQuery = true)
  List<LoanApplication> getPendingLoans(@Param("flg") Integer flg);

  //--exec mpesa_b2c_intial_response 0, '202210081154311936300000', 'AG_20230203_20106109c32d577022ec', '19622-242464723-6', '0', 'Accept the service request successfully.';
  //](@flg as int,@refno varchar(100), @conversationID as varchar(200)
  //		,@originatorConversationID as varchar(200), @responseCode as varchar(50), @responseDescription as varchar(100)
  @Query(value = "{CALL mpesa_b2c_intial_response(:flg, :refno, :conversationID, :originatorConversationID, :responseCode, :responseDescription)}", nativeQuery = true)
  String updateInitiatePayment(
      @Param("flg") Integer flg,
      @Param("refno") String refno,
      @Param("conversationID") String conversationID,
      @Param("originatorConversationID") String originatorConversationID,
      @Param("responseCode") String responseCode,
      @Param("responseDescription") String responseDescription);

  @Query(value =
      "{CALL mpesa_b2c_final_response(:flg,:conversationID,:originatorConversationID,:ResultDesc,:ResultType ,:ResultCode, :TransactionID)}", nativeQuery = true)
  String b2cFinalResponse(
      @Param("flg") Integer flg,
      @Param("conversationID") String conversationID,
      @Param("originatorConversationID") String originatorConversationID,
      @Param("ResultDesc") String ResultDesc,
      @Param("ResultType") Integer ResultType,
      @Param("ResultCode") Integer ResultCode,
      @Param("TransactionID") String TransactionID
  );
}
