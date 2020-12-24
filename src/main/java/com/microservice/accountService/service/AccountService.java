package com.microservice.accountService.service;

import java.util.List;

import com.microservice.accountService.dto.AccountDTO;
import com.microservice.accountService.model.Account;

public interface AccountService {

	public List<Account> getAll();
	
	public void createAccount(AccountDTO accountDTO);
}
