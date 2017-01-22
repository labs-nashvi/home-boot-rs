package com.nashvi.labs.accounts;

import java.util.List;

public interface AccountsService {

	public List<Account> findAll();

	public Account findById(Long id) throws AccountNotFoundException;

	public Account save(Account account, boolean isNewSave);

	public Account updateByAccountId(Long id, Account account) throws AccountNotFoundException;

	public void delete(Long id) throws AccountNotFoundException;

}
