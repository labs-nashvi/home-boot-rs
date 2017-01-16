package com.nashvi.labs.accounts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl implements AccountsService {

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

	@Override
	public List<Account> findAll() {
		return this.accounts;
	}

	@Override
	public Account findById(int id) throws AccountNotFoundException {
		Account account = this.accounts.stream().filter(a -> a.getId() == id).findAny().orElse(null);
		if (account == null) {
			throw new AccountNotFoundException(id);
		}
		return account;
	}

	@Override
	public Account save(Account account, boolean isNewSave) {
		if (isNewSave) {
			account.setOpenedOn(new Date());
		}
		this.accounts.add(account);
		return account;
	}

	@Override
	public void delete(int id) throws AccountNotFoundException {
		this.accounts.remove(findById(id));
	}

	@Override
	public Account updateById(int id, Account account) throws AccountNotFoundException {
		Account findById = findById(id);
		Account reqAccount = AccountsUtil.updateOldAccount(account, findById);
		delete(id);
		return save(reqAccount, false);
	}

}
