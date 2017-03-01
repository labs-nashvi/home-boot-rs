package com.nashvi.labs.accounts;

import java.util.List;

public interface AccountsService {

	public List<Accounts> findAll();

	public Accounts findById(Long id) throws AccountNotFoundException;

	public Accounts save(Accounts account, boolean isNewSave);

	public Accounts updateByAccountId(Long id, Accounts account) throws AccountNotFoundException;

	public void delete(Long id) throws AccountNotFoundException;

}
