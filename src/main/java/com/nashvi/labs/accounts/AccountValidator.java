package com.nashvi.labs.accounts;

public class AccountValidator {
	public static void validateNewAccountData(Account newAccount) {
		if (newAccount.getOpeningBalance() <= 0) {
			throw new AccountValidatorException("Opening balance cannot be zero for new account.");
		}
	}
}
