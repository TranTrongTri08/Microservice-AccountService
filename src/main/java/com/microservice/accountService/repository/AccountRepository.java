package com.microservice.accountService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.accountService.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
