package com.nashvi.labs.accounts;

import java.util.Date;

public class AccountsUtil {

	public static Accounts copyPropertyChange(Accounts newAccount, Accounts oldAccount) {
		if (newAccount.getName() != null) {
			oldAccount.setName(newAccount.getName());
		}
		if (newAccount.getOpeningBalance() >= 0) {
			oldAccount.setOpeningBalance(newAccount.getOpeningBalance());
		}
		if (newAccount.getClosingBalance() >= 0) {
			oldAccount.setClosingBalance(newAccount.getClosingBalance());
		}
		if (newAccount.getAccountType() != null) {
			oldAccount.setAccountType(newAccount.getAccountType());
		}

		oldAccount.setModifiedOn(new Date());

		return oldAccount;
	}
}
