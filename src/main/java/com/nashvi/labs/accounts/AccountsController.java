package com.nashvi.labs.accounts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class AccountsController {

	// @formatter:off
	private List<Account> accounts = new ArrayList<>(
			Arrays.asList(
					new Account(1, AccountType.DEBIT, "BOFA-x7777", 0.0, 0.0, new Date(), null),
					new Account(2, AccountType.CREDIT, "BOFA-x7171", 0.0, 0.0, new Date(), null),
					new Account(3, AccountType.CREDIT, "AMEX-x2004", 0.0, 0.0, new Date(), null),
					new Account(4, AccountType.CHECKING, "BOFA-x7123", 0.0, 0.0, new Date(), null),
					new Account(5, AccountType.LINKED, "Walmart Pay", 0.0, 0.0, new Date(), null))
			);
	// @formatter:on

	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public AccountWrapper getAccounts() {
		return new AccountWrapper("List of all Accounts", this.accounts);
	}

	@RequestMapping(value = "/accounts/add", method = RequestMethod.POST)
	public AccountWrapper addNewAccount(@RequestBody Account account) {
		this.accounts.add(account);
		return new AccountWrapper("New Account successfully added", account);
	}

	@RequestMapping(value = "/accounts/edit", method = RequestMethod.PUT)
	public AccountWrapper editAccount(@RequestBody Account account) {
		if (this.accounts.contains(account)) {
			int indexOf = this.accounts.indexOf(account);

			Account oldAccount = this.accounts.get(indexOf);
			Account reqAccount = updateOldAccount(account, oldAccount);
			this.accounts.remove(indexOf);
			this.accounts.add(indexOf, reqAccount);
			return new AccountWrapper("Account: {" + reqAccount.getName() + "} successfully updated.",
					this.accounts.get(indexOf));
		}
		throw new AccountNotFoundException(account.getId());
	}

	private Account updateOldAccount(Account requestedAccount, Account oldAccount) {
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

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
	public AccountWrapper editAccountById(@RequestBody Account account, @PathVariable int id) {
		Account requestedAccount = new Account(id);
		if (this.accounts.contains(requestedAccount)) {
			int indexOf = this.accounts.indexOf(requestedAccount);

			Account oldAccount = this.accounts.get(indexOf);
			Account reqAccount = updateOldAccount(account, oldAccount);

			this.accounts.remove(indexOf);
			this.accounts.add(indexOf, reqAccount);
			return new AccountWrapper("Account-by-id: {" + reqAccount.getId() + "} successfully updated.",
					this.accounts.get(this.accounts.indexOf(requestedAccount)));
		}
		return new AccountWrapper("ERROR: Account: {" + requestedAccount.getId() + "} does not exist");
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
	public AccountWrapper getAccountById(@PathVariable int id) {
		Account account = new Account(id);
		if (this.accounts.contains(account)) {
			return new AccountWrapper("Requested account-by-id details",
					this.accounts.get(this.accounts.indexOf(account)));
		}
		throw new AccountNotFoundException(id);
	}
}
