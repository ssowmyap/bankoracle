package com.capg.Banking.Service;

import com.capg.Banking.AccountDetails;

public interface IRegLogPageService {
	AccountDetails login(AccountDetails accountNo);
	int register(AccountDetails details);
}
