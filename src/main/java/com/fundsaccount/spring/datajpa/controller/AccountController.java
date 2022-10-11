package com.fundsaccount.spring.datajpa.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fundsaccount.spring.datajpa.model.Account;
import com.fundsaccount.spring.datajpa.repository.AccountRepository;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/")
public class AccountController {

	@Autowired
	AccountRepository AccountRepository;

	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllAccount(@RequestParam(required = false) String accoutnName) {
		try {
			List<Account> ac = new ArrayList<Account>();

			if (accoutnName == null){
				AccountRepository.findAll().forEach(ac::add);
			}
			if (ac.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(ac, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/account/{id}")
	public ResponseEntity<Account> getAccountById(@PathVariable("id") long id) {
		Optional<Account> accountData = AccountRepository.findById(id);

		if (accountData.isPresent()) {
			return new ResponseEntity<>(accountData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/account")
	public ResponseEntity<Account> createAccount(@RequestBody Account ac) {
		try {
			Account _account= AccountRepository
					.save(new Account(ac.getAccountType(), ac.getAccountType(),ac.getAccoutnName(), ac.getBalance(), ac.getDate()));
			return new ResponseEntity<>(_account, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/account/{id}")
	public ResponseEntity<Account> updatePerson(@PathVariable("id") long id, @RequestBody Account ac) {
		Optional<Account> PersonData = AccountRepository.findById(id);

		if (PersonData.isPresent()) {
			Account _account = PersonData.get();
			_account.setAccountNo(ac.getAccountNo());
			_account.setAccountType(ac.getAccountType());
			_account.setAccoutnName(ac.getAccoutnName());
			_account.setBalance(ac.getBalance());
			_account.setDate(ac.getDate());
			return new ResponseEntity<>(AccountRepository.save(_account), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/account/{id}")
	public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable("id") long id) {
		try {
			AccountRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
