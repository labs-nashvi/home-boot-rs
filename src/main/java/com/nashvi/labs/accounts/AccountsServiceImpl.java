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
	public List<Accounts> findAll() {
		List<Accounts> accounts = new ArrayList<>();
		repository.findAll().forEach(accounts::add);
		return accounts;
	}

	@Override
	public Accounts findById(Long id) throws AccountNotFoundException {
		Accounts account = repository.findOne(id);
		if (account == null) {
			throw new AccountNotFoundException(id);
		}
		return account;
	}

	@Override
	public Accounts save(Accounts account, boolean isNewSave) {
		// AccountValidator.validateNewAccountData(account);
		if (isNewSave) {
			account.setOpenedOn(new Date());
		}
		return repository.save(account);
	}

	@Override
	public void delete(Long id) throws AccountNotFoundException {
		Accounts findById = findById(id);
		repository.delete(findById);
	}

	@Override
	public Accounts updateByAccountId(Long id, Accounts account) throws AccountNotFoundException {
		Accounts findById = findById(id);
		Accounts reqAccount = AccountsUtil.copyPropertyChange(account, findById);
		reqAccount.setModifiedOn(new Date());
		return repository.save(reqAccount);
	}

}
