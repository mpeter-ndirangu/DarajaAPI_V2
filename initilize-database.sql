CREATE DATABASE [daraja-db]
GO

USE [daraja-db];
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
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

GO
