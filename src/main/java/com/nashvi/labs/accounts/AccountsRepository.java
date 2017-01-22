package com.nashvi.labs.accounts;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface AccountsRepository extends CrudRepository<Account, Long> {

}
