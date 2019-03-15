package com.capg.Banking.ui;

import java.util.Scanner;

import com.capg.Banking.AccountDetails;
import com.capg.Banking.TransactionDetails;
import com.capg.Banking.Service.IRegLogPageService;
import com.capg.Banking.Service.ITransactionService;
import com.capg.Banking.Service.RegLogPageservice;
import com.capg.Banking.Service.TransactionService;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		IRegLogPageService r1=new RegLogPageservice();
		ITransactionService t1 = new TransactionService();
		AccountDetails customerDetails = new AccountDetails();
		AccountDetails cd=new AccountDetails();
		TransactionDetails td=new TransactionDetails();
		do {
			System.out.println("Menu");
					System.out.println( "1. Registration\n2. Login");
			int menu = sc.nextInt();
			switch (menu) {
			case 1:
				System.out.println("Register a new password");
				customerDetails.setPassward(sc.next());
				System.out.println("Enter first name and last name");
				customerDetails.setFirstName(sc.next());
				customerDetails.setLastName(sc.next());
				System.out.println("Enter email id");
				customerDetails.setEmailId(sc.next());
				System.out.println("Enter aadhaar card number");
				customerDetails.setAadharcardNo(sc.next());
				System.out.println("Enter pan card number");
				customerDetails.setPancardNo(sc.next());
				System.out.println("Enter mobile number");
				customerDetails.setMobileNo(sc.nextLong());
				System.out.println("Enter the address");
				customerDetails.setAddress(sc.next());
				
				int accNo = r1.register(customerDetails);
				if(accNo!=0)
				System.out.println("Registration Successful. Account no: " + accNo);
					break;
			case 2:
				System.out.println("Login page");
				System.out.println("Enter account number");
				customerDetails.setAccountNo(sc.nextInt());
				System.out.println("Enter password");
				customerDetails.setPassward(sc.next());
				cd = r1.login(customerDetails);
				if ( cd!= null) {
					System.out.println("Welcome " + cd.getFirstName());
					do {
						System.out.println("Choose any operation\n1. deposit\n2. withdraw\n3. Balance Enquiry\n4. Fund Transfer\n5. Exit");
						int key = sc.nextInt();
						switch (key) {
						case 1:
							System.out.println("Enter deposit amount");
							customerDetails.setAmount(sc.nextDouble());
							cd=t1.deposit(cd);
							if(cd!=null)
							System.out.println("Remaining balance: "+cd.getBalance());
							break;

						case 2:
							System.out.println("Enter withdraw amount");
							customerDetails.setAmount(sc.nextDouble());
							cd=t1.withdraw(cd);
							if(cd!=null)
							System.out.println(" balance: "+customerDetails.getBalance());
							break;
						case 3:
							cd = t1.showBalance(cd);
							System.out.println("Your balance is: " + cd.getBalance());
							break;
						case 4:
							System.out.println("Enter the fund amount to transfer");
							cd.setAmount(sc.nextDouble());
							System.out.println("Enter the account number to which fund has to be transferred");
							td.setToAccountNo(sc.nextInt());
							cd = t1.fundtransfer(cd);
							if(cd != null)
							System.out.println("Fundtransfered successful from " + cd.getAccountNo()
									+ " to " + td.getToAccountNo() + ". Amount transferred: "
									+ customerDetails.getAmount());
							break;


						case 5:
							System.exit(0);
						default:
							System.err.println("Invalid Choice");
							break;
						}
					} while (true);
				} else
					System.out.println("Account number or password incorrect");
				break;

			default:
				System.err.println("Invalid Choice");
				break;
			}
	
			}while (true);
}
	}	


