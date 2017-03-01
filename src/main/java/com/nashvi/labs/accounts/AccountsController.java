package com.nashvi.labs.accounts;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountsController {

	@Autowired
	private AccountsService service;

	@RequestMapping(value = "/accounts", method = RequestMethod.GET)
	public AccountsWrapper getAccounts() {
		return new AccountsWrapper("List of Accounts", this.service.findAll());
	}

	@RequestMapping(value = "/accounts/add", method = RequestMethod.POST)
	public AccountsWrapper addNewAccount(@RequestBody Accounts account) {
		return new AccountsWrapper("New Account successfully added", this.service.save(account, true));
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.PUT)
	public AccountsWrapper updateAccountById(@RequestBody Accounts account, @PathVariable Long id) {
		return new AccountsWrapper("Account-by-id: {" + id + "} successfully updated.",
				this.service.updateByAccountId(id, account));
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.GET)
	public AccountsWrapper getAccountById(@PathVariable Long id) {
		return new AccountsWrapper("Requested account-by-id details", this.service.findById(id));
	}

	@RequestMapping(value = "/accounts/{id}", method = RequestMethod.DELETE)
	public AccountsWrapper deleteAccountById(@PathVariable Long id) {
		this.service.delete(id);
		return new AccountsWrapper(String.format("Requested account-by-id: {%s} removed successfully", id));
	}

}
