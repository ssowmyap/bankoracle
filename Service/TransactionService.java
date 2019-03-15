package com.capg.Banking.Service;

import com.capg.Banking.AccountDetails;
import com.capg.Banking.DAO.ITransactionDAO;
import com.capg.Banking.DAO.TransactionDAO;

public class TransactionService implements ITransactionService{
	ITransactionDAO it=new TransactionDAO();
	public AccountDetails deposit(AccountDetails a) {
		
		return it.deposit(a);
	}

	public AccountDetails withdraw(AccountDetails a) {
		// TODO Auto-generated method stub
		return it.withdraw(a);
	}

	public AccountDetails showBalance(AccountDetails balance) {
		// TODO Auto-generated method stub
		return it.showBalance(balance);
	}

	public AccountDetails fundtransfer(AccountDetails amounttransfer) {
		// TODO Auto-generated method stub
		return it.fundtransfer(amounttransfer);
	}

}
