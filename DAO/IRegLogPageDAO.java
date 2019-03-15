package com.capg.Banking.DAO;

import com.capg.Banking.AccountDetails;

public interface IRegLogPageDAO {
	int register(AccountDetails details);
	AccountDetails login(AccountDetails account);
}
