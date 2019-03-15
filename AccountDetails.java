package com.capg.Banking;

public class AccountDetails {
	private int AccountNo;
	public int getAccountNo() {
		return AccountNo;
	}
	public void setAccountNo(int accountNo) {
		AccountNo = accountNo;
	}
	private String FirstName;
	private String LastName;
	private String EmailId;
	private String passward;
	private String PancardNo;
	private String AadharcardNo;
	private String Address;
	private long MobileNo;
	private double Balance=0;
	private double Amount;
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public String getPancardNo() {
		return PancardNo;
	}
	public void setPancardNo(String pancardNo) {
		PancardNo = pancardNo;
	}
	public String getAadharcardNo() {
		return AadharcardNo;
	}
	public void setAadharcardNo(String aadharcardNo) {
		AadharcardNo = aadharcardNo;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getMobileNo() {
		return MobileNo;
	}
	public void setMobileNo(long mobileNo) {
		MobileNo = mobileNo;
	}
	public double getBalance() {
		return Balance;
	}
	public  void setBalance(double bal) {
		Balance = bal;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double d) {
		Amount = d;
	}
	public int getToAccountNo() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}
