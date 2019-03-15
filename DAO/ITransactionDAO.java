package com.capg.Banking.DAO;

import com.capg.Banking.AccountDetails;
import com.capg.Banking.TransactionDetails;

public interface ITransactionDAO {
	AccountDetails deposit(AccountDetails a);
	AccountDetails withdraw(AccountDetails a);
	AccountDetails showBalance(AccountDetails balance);
	AccountDetails fundtransfer(AccountDetails amounttransfer);
}
