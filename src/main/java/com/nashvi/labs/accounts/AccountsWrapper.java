package com.nashvi.labs.accounts;

import java.util.Arrays;
import java.util.List;

public class AccountsWrapper {
	private String description;

	private List<Account> accounts;

	public AccountsWrapper() {
	}

	public AccountsWrapper(String description, List<Account> accounts) {
		super();
		this.description = description;
		this.accounts = accounts;
	}

	public AccountsWrapper(String description, Account account) {
		super();
		this.description = description;
		this.accounts = Arrays.asList(account);
	}

	public AccountsWrapper(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

}
