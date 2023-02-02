# DarajaAPI_V2
@Repository
public interface LoanApplicationRepository extends JpaRepository<LoanApplication, Long> {

//  @Query(value = "select id, PhoneNumber as phone_number, LoanNo as ref_no, DisbursedAmount as disbursed_amount,Account_Reference_Number as account_reference_number," +
//      " BuyGoods_No as short_code from dbo.LoanApplications where Disburse_Mode= 1 and DisburseDate is null", nativeQuery = true)

  @Query(value = "CALL mpesa_b2c_fetchrecords(:flg)", nativeQuery = true)
  List<LoanApplication> getPendingLoans(@Param("flg") Integer flg);
}

@Entity
@Data
public class LoanApplication {
  @Id
  @Column
  private long id;
  @Column
  private String phoneNumber;
  @Column
  private String refNo;
  @Column
  private BigDecimal disbursedAmount;
  @Column
  private String accountReferenceNumber;
  @Column
  private String shortCode;

}


@Component
public class ScheduledTasks {
   private final LoanApplicationService loanApplicationService;

  public ScheduledTasks(LoanApplicationService loanApplicationService) {
    this.loanApplicationService = loanApplicationService;
  }

  @Scheduled(fixedRate = 10000)
  public void performTask() {

    List<LoanApplication> loanApplicationList = loanApplicationService.getPendingLoans();

    for (int i = 0; i < loanApplicationList.size(); i++) {
      System.out.println(loanApplicationList.get(i));
      
    }

  }
//
//  @Scheduled(initialDelay = 1000, fixedRate = 10000)
//  public void performDelayedTask() {
//
//    System.out.println("Delayed Regular task performed at "
//        + dateFormat.format(new Date()));
//
//  }
//
//  @Scheduled(cron = "*/5 * * * * *")
//  public void performTaskUsingCron() {
//
//    System.out.println("Regular task performed using Cron at "
//        + dateFormat.format(new Date()));
//
//  }
}
