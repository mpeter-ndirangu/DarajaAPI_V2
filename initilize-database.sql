CREATE DATABASE [Mobility]

USE [Mobility]
GO
/****** Object:  StoredProcedure [dbo].[mpesa_b2c_final_response]    Script Date: 5/22/2023 1:31:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

ALTER procedure [dbo].[mpesa_b2c_final_response](@flg as int, @conversationID as varchar(200),@originatorConversationID as varchar(200)
		,@ResultDesc as varchar(200),@ResultType as numeric(18,0),@ResultCode as numeric(18,0)
		,@TransactionID as varchar(50),@transactionReceipt as varchar(50),@transactionAmount as numeric(18,0)
		,@b2CWorkingAccountAvailableFunds as numeric(18,0),@b2CUtilityAccountAvailableFunds as numeric(18,0)
		,@transactionCompletedDateTime as varchar(50), @receiverPartyPublicName varchar(200)
		)
as
begin
begin try

/*
		exec [dbo].[mpesa_b2c_final_response] 0,'AG_20230203_20106109c32d577022ec','19622-242464723-6'
			,'Service request is has bee accepted successfully', 0, 0
			,'LHG31AA5TX','LHG31AA5TX'
			,100.0, 2000.0, 23654.5
			,'01.08.2018 16:12:12', '254722000000 - Safaricom PLC';
*/

/*		drop table dbo.loanapplications_results
	--select * from dbo.loanapplications_results
	--truncate table dbo.loanapplications_results
		create table dbo.loanapplications_results
		(
			conversationID varchar(200)
			,originatorConversationID varchar(200)
			,ResultDesc varchar(200)
			,ResultType numeric(18,0)
			,ResultCode numeric(18,0)
			,TransactionID varchar(50)
			,TransactionReceipt varchar(50)
			,TransactionAmount numeric(18,2)
			,B2CWorkingAccountAvailableFunds numeric(18,2)
			,B2CUtilityAccountAvailableFunds numeric(18,2)
			,TransactionCompletedDateTime varchar(50)
			,ReceiverPartyPublicName varchar(200)
			,B2CRecipientIsRegisteredCustomer varchar(5)
			,trdate datetime default(getdate()) not null
		);
*/

set @conversationID=ltrim(rtrim(isnull(@conversationID,'')));
		set @originatorConversationID=ltrim(rtrim(isnull(@originatorConversationID,'')));
		set @ResultDesc=ltrim(rtrim(isnull(@ResultDesc,'')));
		set @ResultType=isnull(@ResultType,-9999);
		set @ResultCode=isnull(@ResultCode,-9999);
		set @TransactionID=ltrim(rtrim(isnull(@TransactionID,'')));
		set @transactionReceipt=ltrim(rtrim(isnull(@transactionReceipt,'')));
		set @transactionAmount=isnull(@transactionAmount,0.0);
		set @b2CWorkingAccountAvailableFunds=isnull(@b2CWorkingAccountAvailableFunds,0.0);
		set @b2CUtilityAccountAvailableFunds=isnull(@b2CUtilityAccountAvailableFunds,0.0);
		set @transactionCompletedDateTime=ltrim(rtrim(isnull(@transactionCompletedDateTime,'')));
		set @receiverPartyPublicName=ltrim(rtrim(isnull(@receiverPartyPublicName,'')));

		if @flg=0 and len(ltrim(rtrim(@conversationID)))>1
begin
insert into dbo.loanapplications_results
(
    conversationID
,originatorConversationID
,ResultDesc
,ResultType
,ResultCode
,TransactionID
,TransactionReceipt
,TransactionAmount
,B2CWorkingAccountAvailableFunds
,B2CUtilityAccountAvailableFunds
,TransactionCompletedDateTime
,ReceiverPartyPublicName
)
values
    (@conversationID
    ,@originatorConversationID
    ,@ResultDesc
    ,@ResultType
    ,@ResultCode
    ,@TransactionID
    ,@transactionReceipt
    ,@transactionAmount
    ,@b2CWorkingAccountAvailableFunds
    ,@b2CUtilityAccountAvailableFunds
    ,@transactionCompletedDateTime
    ,@receiverPartyPublicName
    );

update dbo.loanapplications set mpesa_ref=@TransactionID where originatorConversationID=@originatorConversationID;


select '1 - processed successfully.' msg;

end
else
begin
select '0 - nothing was processed.' msg;

end
end try
begin catch
select '0 - error(s) occurred.' msg;
end catch


end


------------------------

USE [Mobility]
GO
/****** Object:  StoredProcedure [dbo].[mpesa_b2c_final_response]    Script Date: 5/22/2023 1:31:08 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

ALTER procedure [dbo].[mpesa_b2c_final_response](@flg as int, @conversationID as varchar(200),@originatorConversationID as varchar(200)
		,@ResultDesc as varchar(200),@ResultType as numeric(18,0),@ResultCode as numeric(18,0)
		,@TransactionID as varchar(50),@transactionReceipt as varchar(50),@transactionAmount as numeric(18,0)
		,@b2CWorkingAccountAvailableFunds as numeric(18,0),@b2CUtilityAccountAvailableFunds as numeric(18,0)
		,@transactionCompletedDateTime as varchar(50), @receiverPartyPublicName varchar(200)
		)
as
begin
begin try

/*
		exec [dbo].[mpesa_b2c_final_response] 0,'AG_20230203_20106109c32d577022ec','19622-242464723-6'
			,'Service request is has bee accepted successfully', 0, 0
			,'LHG31AA5TX','LHG31AA5TX'
			,100.0, 2000.0, 23654.5
			,'01.08.2018 16:12:12', '254722000000 - Safaricom PLC';
*/

/*		drop table dbo.loanapplications_results
	--select * from dbo.loanapplications_results
	--truncate table dbo.loanapplications_results
		create table dbo.loanapplications_results
		(
			conversationID varchar(200)
			,originatorConversationID varchar(200)
			,ResultDesc varchar(200)
			,ResultType numeric(18,0)
			,ResultCode numeric(18,0)
			,TransactionID varchar(50)
			,TransactionReceipt varchar(50)
			,TransactionAmount numeric(18,2)
			,B2CWorkingAccountAvailableFunds numeric(18,2)
			,B2CUtilityAccountAvailableFunds numeric(18,2)
			,TransactionCompletedDateTime varchar(50)
			,ReceiverPartyPublicName varchar(200)
			,B2CRecipientIsRegisteredCustomer varchar(5)
			,trdate datetime default(getdate()) not null
		);
*/

set @conversationID=ltrim(rtrim(isnull(@conversationID,'')));
		set @originatorConversationID=ltrim(rtrim(isnull(@originatorConversationID,'')));
		set @ResultDesc=ltrim(rtrim(isnull(@ResultDesc,'')));
		set @ResultType=isnull(@ResultType,-9999);
		set @ResultCode=isnull(@ResultCode,-9999);
		set @TransactionID=ltrim(rtrim(isnull(@TransactionID,'')));
		set @transactionReceipt=ltrim(rtrim(isnull(@transactionReceipt,'')));
		set @transactionAmount=isnull(@transactionAmount,0.0);
		set @b2CWorkingAccountAvailableFunds=isnull(@b2CWorkingAccountAvailableFunds,0.0);
		set @b2CUtilityAccountAvailableFunds=isnull(@b2CUtilityAccountAvailableFunds,0.0);
		set @transactionCompletedDateTime=ltrim(rtrim(isnull(@transactionCompletedDateTime,'')));
		set @receiverPartyPublicName=ltrim(rtrim(isnull(@receiverPartyPublicName,'')));

		if @flg=0 and len(ltrim(rtrim(@conversationID)))>1
begin
insert into dbo.loanapplications_results
(
    conversationID
,originatorConversationID
,ResultDesc
,ResultType
,ResultCode
,TransactionID
,TransactionReceipt
,TransactionAmount
,B2CWorkingAccountAvailableFunds
,B2CUtilityAccountAvailableFunds
,TransactionCompletedDateTime
,ReceiverPartyPublicName
)
values
    (@conversationID
    ,@originatorConversationID
    ,@ResultDesc
    ,@ResultType
    ,@ResultCode
    ,@TransactionID
    ,@transactionReceipt
    ,@transactionAmount
    ,@b2CWorkingAccountAvailableFunds
    ,@b2CUtilityAccountAvailableFunds
    ,@transactionCompletedDateTime
    ,@receiverPartyPublicName
    );

update dbo.loanapplications set mpesa_ref=@TransactionID where originatorConversationID=@originatorConversationID;


select '1 - processed successfully.' msg;

end
else
begin
select '0 - nothing was processed.' msg;

end
end try
begin catch
select '0 - error(s) occurred.' msg;
end catch


end


use Mobility;
GO
CREATE TABLE [dbo].[LoanApplications](
    [id] [numeric](38, 0) IDENTITY(1,1) NOT NULL,
    [PhoneNumber] [varchar](50) NOT NULL,
    [LoanNo] [varchar](100) NOT NULL,
    [AppliedAmount] [numeric](18, 2) NOT NULL,
    [AppliedDate] [datetime] NULL,
    [ApprovedAmount] [numeric](18, 2) NOT NULL,
    [ApprovedDate] [datetime] NULL,
    [DisbursedAmount] [numeric](18, 2) NOT NULL,
    [CommissionAmount] [numeric](18, 2) NOT NULL,
    [DisburseDate] [datetime] NULL,
    [DueDate] [datetime] NOT NULL,
    [FullyPaid] [int] NOT NULL,
    [DisburseRefNumber] [varchar](500) NOT NULL,
    [SessionId] [numeric](38, 0) NULL,
    [DisburseRespCode] [varchar](100) NOT NULL,
    [RefNo] [varchar](150) NOT NULL,
    [TxnType] [varchar](50) NOT NULL,
    [LoanRefNo] [varchar](50) NOT NULL,
    [Disburse_Mode] [int] NOT NULL,
    [mpesa_ref] [varchar](150) NOT NULL,
    [mserial] [varchar](100) NOT NULL,
    [customer_acno] [varchar](50) NOT NULL,
    [internal_acno] [varchar](50) NOT NULL,
    [DisburseRespCode_Remarks] [varchar](150) NULL,
    [ref_processed_flg] [int] NOT NULL,
    [ResultCode] [varchar](50) NOT NULL,
    [ResultDescription] [varchar](100) NOT NULL,
    [Account_Reference_Number] [varchar](50) NOT NULL,
    [BuyGoods_No] [varchar](50) NOT NULL,
    [BuyGoods_Type] [varchar](50) NOT NULL,
    CONSTRAINT [PK_LoanApplications] PRIMARY KEY CLUSTERED
(
[LoanNo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
    ) ON [PRIMARY]
    GO
    SET IDENTITY_INSERT [dbo].[LoanApplications] ON

    INSERT [dbo].[LoanApplications] ([id], [PhoneNumber], [LoanNo], [AppliedAmount], [AppliedDate], [ApprovedAmount], [ApprovedDate], [DisbursedAmount], [CommissionAmount], [DisburseDate], [DueDate], [FullyPaid], [DisburseRefNumber], [SessionId], [DisburseRespCode], [RefNo], [TxnType], [LoanRefNo], [Disburse_Mode], [mpesa_ref], [mserial], [customer_acno], [internal_acno], [DisburseRespCode_Remarks], [ref_processed_flg], [ResultCode], [ResultDescription], [Account_Reference_Number], [BuyGoods_No], [BuyGoods_Type]) VALUES (CAST(1 AS Numeric(38, 0)), N'254719448033', N'202210081154311936300000', CAST(500.00 AS Numeric(18, 2)), CAST(N'2022-10-08T11:54:31.487' AS DateTime), CAST(500.00 AS Numeric(18, 2)), CAST(N'2022-10-08T11:54:31.487' AS DateTime), CAST(500.00 AS Numeric(18, 2)), CAST(0.00 AS Numeric(18, 2)), CAST(N'2022-10-08T11:54:56.000' AS DateTime), CAST(N'2022-10-08T11:54:31.487' AS DateTime), 1, N'AG_20221008_201023d218709bcaaf71', CAST(3 AS Numeric(38, 0)), N'000000000', N'', N'SavTrf', N'', 1, N'KDH7J92CQT', N'3_Posted Successfully_202210081143128440640000', N'101002020537310100', N'101001000006100100', NULL, 1, N'0', N'The service request is processed successfully.', N'0744130000132', N'200999', N'Paybill')
    INSERT [dbo].[LoanApplications] ([id], [PhoneNumber], [LoanNo], [AppliedAmount], [AppliedDate], [ApprovedAmount], [ApprovedDate], [DisbursedAmount], [CommissionAmount], [DisburseDate], [DueDate], [FullyPaid], [DisburseRefNumber], [SessionId], [DisburseRespCode], [RefNo], [TxnType], [LoanRefNo], [Disburse_Mode], [mpesa_ref], [mserial], [customer_acno], [internal_acno], [DisburseRespCode_Remarks], [ref_processed_flg], [ResultCode], [ResultDescription], [Account_Reference_Number], [BuyGoods_No], [BuyGoods_Type]) VALUES (CAST(2 AS Numeric(38, 0)), N'254723299909', N'202210081245406029820000', CAST(1000.00 AS Numeric(18, 2)), CAST(N'2022-10-08T12:45:40.873' AS DateTime), CAST(1000.00 AS Numeric(18, 2)), CAST(N'2022-10-08T12:45:40.873' AS DateTime), CAST(1000.00 AS Numeric(18, 2)), CAST(0.00 AS Numeric(18, 2)), CAST(N'2022-10-08T12:46:38.000' AS DateTime), CAST(N'2022-10-08T12:45:40.873' AS DateTime), 1, N'AG_20221008_20300828b97db24f69e3', CAST(4 AS Numeric(38, 0)), N'000000000', N'', N'SavTrf', N'', 1, N'KDH2J997QW', N'3_Posted Successfully_202210081234227770360000', N'101006098222310100', N'101001000006100100', NULL, 1, N'0', N'The service request is processed successfully.', N'0744130000132', N'200999', N'Paybill')
    INSERT [dbo].[LoanApplications] ([id], [PhoneNumber], [LoanNo], [AppliedAmount], [AppliedDate], [ApprovedAmount], [ApprovedDate], [DisbursedAmount], [CommissionAmount], [DisburseDate], [DueDate], [FullyPaid], [DisburseRefNumber], [SessionId], [DisburseRespCode], [RefNo], [TxnType], [LoanRefNo], [Disburse_Mode], [mpesa_ref], [mserial], [customer_acno], [internal_acno], [DisburseRespCode_Remarks], [ref_processed_flg], [ResultCode], [ResultDescription], [Account_Reference_Number], [BuyGoods_No], [BuyGoods_Type]) VALUES (CAST(3 AS Numeric(38, 0)), N'254720242995', N'202210081609188912840000', CAST(15000.00 AS Numeric(18, 2)), CAST(N'2022-10-08T16:09:18.177' AS DateTime), CAST(15000.00 AS Numeric(18, 2)), CAST(N'2022-10-08T16:09:18.177' AS DateTime), CAST(15000.00 AS Numeric(18, 2)), CAST(0.00 AS Numeric(18, 2)), CAST(N'2022-10-08T16:09:59.000' AS DateTime), CAST(N'2022-10-08T16:09:18.177' AS DateTime), 1, N'AG_20221008_20101711a71c0b9011a4', CAST(12 AS Numeric(38, 0)), N'000000000', N'', N'SavTrf', N'', 0, N'KE62OODAJM', N'3_Posted Successfully_202210081558122592230000', N'101002011707310100', N'101001000006100100', NULL, 1, N'1', N'The balance is insufficient for the transaction.', N'', N'', N'')
    INSERT [dbo].[LoanApplications] ([id], [PhoneNumber], [LoanNo], [AppliedAmount], [AppliedDate], [ApprovedAmount], [ApprovedDate], [DisbursedAmount], [CommissionAmount], [DisburseDate], [DueDate], [FullyPaid], [DisburseRefNumber], [SessionId], [DisburseRespCode], [RefNo], [TxnType], [LoanRefNo], [Disburse_Mode], [mpesa_ref], [mserial], [customer_acno], [internal_acno], [DisburseRespCode_Remarks], [ref_processed_flg], [ResultCode], [ResultDescription], [Account_Reference_Number], [BuyGoods_No], [BuyGoods_Type]) VALUES (CAST(4 AS Numeric(38, 0)), N'254799491326', N'202210091856444350970000', CAST(1000.00 AS Numeric(18, 2)), CAST(N'2022-10-09T18:56:44.883' AS DateTime), CAST(1000.00 AS Numeric(18, 2)), CAST(N'2022-10-09T18:56:44.883' AS DateTime), CAST(1000.00 AS Numeric(18, 2)), CAST(0.00 AS Numeric(18, 2)), CAST(N'2022-10-09T18:56:48.000' AS DateTime), CAST(N'2022-10-09T18:56:44.883' AS DateTime), 1, N'AG_20221009_20207b82866d06ef7cf2', CAST(69 AS Numeric(38, 0)), N'000000000', N'', N'SavTrf', N'', 0, N'KES8ULK9OE', N'3_Posted Successfully_202210091845379973820000', N'101009135138310500', N'101001000006100100', NULL, 1, N'0', N'The service request is processed successfully.', N'', N'', N'')
    INSERT [dbo].[LoanApplications] ([id], [PhoneNumber], [LoanNo], [AppliedAmount], [AppliedDate], [ApprovedAmount], [ApprovedDate], [DisbursedAmount], [CommissionAmount], [DisburseDate], [DueDate], [FullyPaid], [DisburseRefNumber], [SessionId], [DisburseRespCode], [RefNo], [TxnType], [LoanRefNo], [Disburse_Mode], [mpesa_ref], [mserial], [customer_acno], [internal_acno], [DisburseRespCode_Remarks], [ref_processed_flg], [ResultCode], [ResultDescription], [Account_Reference_Number], [BuyGoods_No], [BuyGoods_Type]) VALUES (CAST(5 AS Numeric(38, 0)), N'254704820388', N'202210091857427839300000', CAST(1000.00 AS Numeric(18, 2)), CAST(N'2022-10-09T18:57:42.450' AS DateTime), CAST(1000.00 AS Numeric(18, 2)), CAST(N'2022-10-09T18:57:42.450' AS DateTime), CAST(1000.00 AS Numeric(18, 2)), CAST(0.00 AS Numeric(18, 2)), CAST(N'2022-10-09T18:58:25.000' AS DateTime), CAST(N'2022-10-09T18:57:42.450' AS DateTime), 1, N'AG_20221009_2040448b9f3f907a7f93', CAST(65 AS Numeric(38, 0)), N'000000000', N'', N'SavTrf', N'', 0, N'KG876N4PC7', N'3_Posted Successfully_202210091846352898540000', N'101002012962310100', N'101001000006100100', NULL, 1, N'0', N'The service request is processed successfully.', N'', N'', N'')
    INSERT [dbo].[LoanApplications] ([id], [PhoneNumber], [LoanNo], [AppliedAmount], [AppliedDate], [ApprovedAmount], [ApprovedDate], [DisbursedAmount], [CommissionAmount], [DisburseDate], [DueDate], [FullyPaid], [DisburseRefNumber], [SessionId], [DisburseRespCode], [RefNo], [TxnType], [LoanRefNo], [Disburse_Mode], [mpesa_ref], [mserial], [customer_acno], [internal_acno], [DisburseRespCode_Remarks], [ref_processed_flg], [ResultCode], [ResultDescription], [Account_Reference_Number], [BuyGoods_No], [BuyGoods_Type]) VALUES (CAST(6 AS Numeric(38, 0)), N'254721526301', N'202210091859508482220000', CAST(800.00 AS Numeric(18, 2)), CAST(N'2022-10-09T18:59:50.120' AS DateTime), CAST(800.00 AS Numeric(18, 2)), CAST(N'2022-10-09T18:59:50.120' AS DateTime), CAST(800.00 AS Numeric(18, 2)), CAST(0.00 AS Numeric(18, 2)), CAST(N'2022-10-09T19:00:05.000' AS DateTime), CAST(N'2022-10-09T18:59:50.120' AS DateTime), 1, N'AG_20221009_20304b16d042f18924e6', CAST(87 AS Numeric(38, 0)), N'000000000', N'', N'SavTrf', N'', 0, N'KH46DX3VNI', N'3_Posted Successfully_202210091848429861570000', N'101005076293310100', N'101001000006100100', NULL, 1, N'0', N'The service request is processed successfully.', N'', N'', N'')
    SET IDENTITY_INSERT [dbo].[LoanApplications] OFF
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF_LoanApplications_PhoneNumber]  DEFAULT ('') FOR [PhoneNumber]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF_LoanApplications_LoanNo]  DEFAULT ('') FOR [LoanNo]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF_LoanApplications_AppliedAmount]  DEFAULT ((0)) FOR [AppliedAmount]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF_LoanApplications_DisbursedAmount]  DEFAULT ((0)) FOR [DisbursedAmount]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF_LoanApplications_CommissionAmount]  DEFAULT ((0)) FOR [CommissionAmount]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF_LoanApplications_FullyPaid]  DEFAULT ((0)) FOR [FullyPaid]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF_LoanApplications_DisburseRefNumber]  DEFAULT ('') FOR [DisburseRefNumber]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF__LoanAppli__Disbu__66603565]  DEFAULT ('') FOR [DisburseRespCode]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF_LoanApplications_RefNo]  DEFAULT ('') FOR [RefNo]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF__LoanAppli__TxnTy__5EBF139D]  DEFAULT ('') FOR [TxnType]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF_LoanApplications_LoanRefNo]  DEFAULT ('') FOR [LoanRefNo]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  DEFAULT ((0)) FOR [Disburse_Mode]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF_LoanApplications_mpesa_ref]  DEFAULT ('') FOR [mpesa_ref]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  CONSTRAINT [DF_LoanApplications_mserial]  DEFAULT ('') FOR [mserial]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  DEFAULT ('') FOR [customer_acno]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  DEFAULT ('') FOR [internal_acno]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  DEFAULT ((1)) FOR [ref_processed_flg]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  DEFAULT ('') FOR [ResultCode]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  DEFAULT ('') FOR [ResultDescription]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  DEFAULT ('') FOR [Account_Reference_Number]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  DEFAULT ('') FOR [BuyGoods_No]
    GO
ALTER TABLE [dbo].[LoanApplications] ADD  DEFAULT ('') FOR [BuyGoods_Type]
    GO

alter table loanapplications add originatorConversationID varchar(200) default('') not null;

--select * from loanapplications where loanno='202210081154311936300000'


--{"conversationID":"AG_20230203_20106109c32d577022ec","originatorConversationID":"19622-242464723-6","responseCode":"0","responseDescription":"Accept the service request successfully."}

GO
create procedure [dbo].[mpesa_b2c_intial_response](@flg as int,@refno varchar(100), @conversationID as varchar(200)
		,@originatorConversationID as varchar(200), @responseCode as varchar(50), @responseDescription as varchar(100)
		--,@disbursedatetime as varchar(100) --2022-01-01 13:01:01
		)
as
begin
begin try
		--exec mpesa_b2c_intial_response 0, '202210081154311936300000', 'AG_20230203_20106109c32d577022ec', '19622-242464723-6', '0', 'Accept the service request successfully.','2022-01-01 13:01:01';
set @refno=ltrim(rtrim(isnull(@refno,'')));
		set @conversationID=ltrim(rtrim(isnull(@conversationID,'')));
		set @originatorConversationID=ltrim(rtrim(isnull(@originatorConversationID,'')));
		set @responseCode=ltrim(rtrim(isnull(@responseCode,'')));
		set @responseDescription=ltrim(rtrim(isnull(@responseDescription,'')));

		if @flg=0 and len(ltrim(rtrim(@refno)))>0 and len(ltrim(rtrim(@conversationID)))>1
begin
update dbo.loanapplications set
    DisburseRefNumber=@conversationID, DisburseRespCode=@responseCode, ResultCode=@responseCode
                              ,ResultDescription=@responseDescription, originatorConversationID=@originatorConversationID
                              ,DisburseDate=getdate()
where LoanNo=@refno;
select '1 - processed successfully.' msg;

end
else
begin
select '0 - nothing was processed.' msg;

end
end try
begin catch
select '0 - error(s) occurred.' msg;
end catch


end
GO


create  procedure [dbo].[mpesa_b2c_fetchrecords](@flg as int)
as
begin
	--exec mpesa_b2c_fetchrecords 0;
	--exec mpesa_b2c_fetchrecords 1;
	if @flg=0
begin
			--fetch to send to mobile no
select id, PhoneNumber, LoanNo RefNo, DisbursedAmount --LoanNo is Ref No
from dbo.LoanApplications where Disburse_Mode=0 and DisburseDate is null;
end
	if @flg=1
begin
			--fetch to send to paybill/till
			--BuyGoods_Type = Paybill/TillNo
			--BuyGoods_No = Actual Till/Paybill Number
			--Account_Reference_Number = Account No for Paybill; will be empty for Payments to Till
select id, PhoneNumber as phone_number, LoanNo as ref_no, DisbursedAmount as disbursed_amount,Account_Reference_Number as account_reference_number, BuyGoods_No as short_code
from dbo.LoanApplications where Disburse_Mode=1 and DisburseDate is null;
end
end


GO
create table dbo.loanapplications_results
(
    conversationID varchar(200)
    ,originatorConversationID varchar(200)
    ,ResultDesc varchar(200)
    ,ResultType numeric(18,0)
    ,ResultCode numeric(18,0)
    ,TransactionID varchar(50)
    ,TransactionReceipt varchar(50)
    ,TransactionAmount numeric(18,2)
    ,B2CWorkingAccountAvailableFunds numeric(18,2)
    ,B2CUtilityAccountAvailableFunds numeric(18,2)
    ,TransactionCompletedDateTime varchar(50)
    ,ReceiverPartyPublicName varchar(200)
    ,B2CRecipientIsRegisteredCustomer varchar(5)
    ,trdate datetime default(getdate()) not null
);

GO


create procedure [dbo].[mpesa_b2c_final_response](@flg as int, @conversationID as varchar(200),@originatorConversationID as varchar(200)
		,@ResultDesc as varchar(200),@ResultType as numeric(18,0),@ResultCode as numeric(18,0)
		,@TransactionID as varchar(50)
		)
as
begin
begin try

/*
		exec [dbo].[mpesa_b2c_final_response] 0,'AG_20230203_20106109c32d577022ec','19622-242464723-6'
			,'Service request is has bee accepted successfully', 0, 0
			,'LHG31AA5TX','LHG31AA5TX'
			,100, 2000, 23654.5
			,'01.08.2018 16:12:12', '254722000000 - Safaricom PLC'
			,'Y';
*/

/*		drop table dbo.loanapplications_results
		create table dbo.loanapplications_results
		(
			conversationID varchar(200)
			,originatorConversationID varchar(200)
			,ResultDesc varchar(200)
			,ResultType numeric(18,0)
			,ResultCode numeric(18,0)
			,TransactionID varchar(50)
			,TransactionReceipt varchar(50)
			,TransactionAmount numeric(18,2)
			,B2CWorkingAccountAvailableFunds numeric(18,2)
			,B2CUtilityAccountAvailableFunds numeric(18,2)
			,TransactionCompletedDateTime varchar(50)
			,ReceiverPartyPublicName varchar(200)
			,B2CRecipientIsRegisteredCustomer varchar(5)
			,trdate datetime default(getdate()) not null
		);
*/

set @conversationID=ltrim(rtrim(isnull(@conversationID,'')));
		set @originatorConversationID=ltrim(rtrim(isnull(@originatorConversationID,'')));
		set @ResultDesc=ltrim(rtrim(isnull(@ResultDesc,'')));
		set @ResultType=isnull(@ResultType,-9999);
		set @ResultCode=isnull(@ResultCode,-9999);
		set @TransactionID=ltrim(rtrim(isnull(@TransactionID,'')));

		if @flg=0 and len(ltrim(rtrim(@conversationID)))>1
begin
insert into dbo.loanapplications_results
(
    conversationID
,originatorConversationID
,ResultDesc
,ResultType
,ResultCode
,TransactionID
)
values
    (@conversationID
    ,@originatorConversationID
    ,@ResultDesc
    ,@ResultType
    ,@ResultCode
    ,@TransactionID
    );

--update dbo.loanapplications set mpesa_ref=@TransactionReceipt where originatorConversationID=@originatorConversationID;


select '1 - processed successfully.' msg;

end
else
begin
select '0 - nothing was processed.' msg;

end
end try
begin catch
select '0 - error(s) occurred.' msg;
end catch


end
GO

select * from loanapplications_results;
