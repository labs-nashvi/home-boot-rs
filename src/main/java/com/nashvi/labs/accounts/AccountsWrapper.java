package com.nashvi.labs.accounts;

import java.util.Arrays;
import java.util.List;

public class AccountsWrapper {
	private String description;

	private List<Accounts> accounts;

	public AccountsWrapper() {
	}

	public AccountsWrapper(String description, List<Accounts> accounts) {
		super();
		this.description = description;
		this.accounts = accounts;
	}

	public AccountsWrapper(String description, Accounts account) {
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

	public List<Accounts> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Accounts> accounts) {
		this.accounts = accounts;
	}

}
