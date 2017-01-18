package com.nashvi.labs.accounts;

import java.util.Date;

public class AccountsUtil {

	public static Account updateOldAccount(Account requestedAccount, Account oldAccount) {
		if (requestedAccount.getName() != null) {
			oldAccount.setName(requestedAccount.getName());
		}
		if (requestedAccount.getOpeningBalance() > 0) {
			oldAccount.setOpeningBalance(requestedAccount.getOpeningBalance());
		}
		if (requestedAccount.getClosingBalance() > 0) {
			oldAccount.setClosingBalance(requestedAccount.getClosingBalance());
		}
		if (requestedAccount.getAccountType() != null) {
			oldAccount.setAccountType(requestedAccount.getAccountType());
		}
		oldAccount.setModifiedOn(new Date());
		return oldAccount;
	}
}
