package com.capg.Banking.Service;

import com.capg.Banking.AccountDetails;
import com.capg.Banking.DAO.IRegLogPageDAO;
import com.capg.Banking.DAO.RegLogPageDAO;

public class RegLogPageservice implements IRegLogPageService{
	IRegLogPageDAO rl=new RegLogPageDAO();
	public AccountDetails login(AccountDetails accountNo) {
	
		return rl.login(accountNo);
	}

	public int register(AccountDetails details) {
		return rl.register(details);
	}
	private boolean validateMobile(String mobile_no) {
		if (mobile_no.length() == 10)
			return true;
		else
			return false;
	}

	private boolean validateAadhaar(String aadhaarNo) {
		if (aadhaarNo.length() == 12)
			return true;
		else
			return false;
	}


}
