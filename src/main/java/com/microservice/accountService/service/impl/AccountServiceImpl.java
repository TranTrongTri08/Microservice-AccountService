package com.microservice.accountService.service.impl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.microservice.accountService.dto.AccountDTO;
import com.microservice.accountService.model.Account;
import com.microservice.accountService.repository.AccountRepository;
import com.microservice.accountService.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
	
	private final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<Account> getAll() {
		logger.info("Get all accounts");
// 		Disable timeout that used to test Hystrix
//		try {
//			logger.info("API take 2000ms to response data");
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		// Test case if API response status code = 500 then invoke fallback method
//		String a = null;
//		a.toString();
		return accountRepository.findAll();
	}

	@Override
	public void createAccount(AccountDTO accountDTO) {
		logger.info("Created account: {}", accountDTO);
		Account account = modelMapper.map(accountDTO, Account.class);
		account.setPassword(passwordEncoder.encode(account.getPassword()));
		accountRepository.save(account);
	}

}
