package com.fundsaccount.spring.datajpa.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.fundsaccount.spring.datajpa.model.Account;


public interface AccountRepository extends JpaRepository<Account, Long> {
}
