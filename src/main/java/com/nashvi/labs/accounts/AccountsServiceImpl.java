package com.nashvi.labs.accounts;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountsServiceImpl implements AccountsService {

	@Autowired
	private AccountsRepository repository;

	@Override
	public List<Account> findAll() {
		List<Account> accounts = new ArrayList<>();
		repository.findAll().forEach(accounts::add);
		return accounts;
	}

	@Override
	public Account findById(Long id) throws AccountNotFoundException {
		Account account = repository.findOne(id);
		if (account == null) {
			throw new AccountNotFoundException(id);
		}
		return account;
	}

	@Override
	public Account save(Account account, boolean isNewSave) {
		// AccountValidator.validateNewAccountData(account);
		if (isNewSave) {
			account.setOpenedOn(new Date());
		}
		return repository.save(account);
	}

	@Override
	public void delete(Long id) throws AccountNotFoundException {
		Account findById = findById(id);
		repository.delete(findById);
	}

	@Override
	public Account updateByAccountId(Long id, Account account) throws AccountNotFoundException {
		Account findById = findById(id);
		Account reqAccount = AccountsUtil.copyPropertyChange(account, findById);
		reqAccount.setModifiedOn(new Date());
		return repository.save(reqAccount);
	}

}
