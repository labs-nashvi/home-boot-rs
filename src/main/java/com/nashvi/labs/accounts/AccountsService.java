package com.nashvi.labs.accounts;

import java.util.List;

public interface AccountsService {

	public List<Account> findAll();

	public Account findById(int id) throws AccountNotFoundException;

	public Account save(Account account, boolean isNewSave);

	public Account updateById(int id, Account account) throws AccountNotFoundException;

	public void delete(int id) throws AccountNotFoundException;

}
