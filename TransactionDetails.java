package com.capg.Banking;

public class TransactionDetails {
	private int TranactionId;
	private double AmountTransfered;
	private int fromAccountNo;
	private int ToAccountNo;
	public int getTranactionId() {
		return TranactionId;
	}
	public void setTranactionId(int tranactionId) {
		TranactionId = tranactionId;
	}
	public double getAmountTransfered() {
		return AmountTransfered;
	}
	public void setAmountTransfered(double amountTransfered) {
		AmountTransfered = amountTransfered;
	}
	public int getFromAccountNo() {
		return fromAccountNo;
	}
	public void setFromAccountNo(int fromAccountNo) {
		this.fromAccountNo = fromAccountNo;
	}
	public int getToAccountNo() {
		return ToAccountNo;
	}
	public void setToAccountNo(int toAccountNo) {
		ToAccountNo = toAccountNo;
	}
	
	
}
