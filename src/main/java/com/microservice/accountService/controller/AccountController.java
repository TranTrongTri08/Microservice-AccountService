package com.microservice.accountService.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.accountService.dto.AccountDTO;
import com.microservice.accountService.model.Account;
import com.microservice.accountService.service.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	private final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private AccountService accountService;
	
	@Autowired
	private Environment environment;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<AccountDTO> getAllAccounts() {
		logger.info("Runnng app on port: {}", environment.getProperty("local.server.port"));
		
		List<Account> accounts = accountService.getAll();
		return Arrays.asList(modelMapper.map(accounts, AccountDTO[].class));
	}
	
	@PostMapping
	public void createAccount(@RequestBody AccountDTO accountDTO) {
		logger.info("Request to create account: {}", accountDTO);
		accountService.createAccount(accountDTO);
	}
	
	@GetMapping("/players")
	public Map<String, Object> getPlayers() {
		Map<String, Object> resp = new HashMap<>();
		resp.put("striker", environment.getProperty("player.striker.name"));
		resp.put("cm", environment.getProperty("player.cm.name"));
		return resp;
	}
}
