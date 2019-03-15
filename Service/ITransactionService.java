package com.capg.Banking.Service;

import com.capg.Banking.AccountDetails;

public interface ITransactionService {
	AccountDetails deposit(AccountDetails a);
	AccountDetails withdraw(AccountDetails a);
	AccountDetails showBalance(AccountDetails balance);
	AccountDetails fundtransfer(AccountDetails amounttransfer);
}
