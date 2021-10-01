package com.example.AccountProject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("account")
public class AccountController {
	@Autowired
	AccountService accountService;
	@GetMapping("/")
	List<Account> getAccounts(){
		System.out.println("called");
		return accountService.getAccounts();
	}
	
	@GetMapping("/{id}")
	public void getAccount(@PathVariable Integer id) {
		
		System.out.println("Account Found");
	}
	

	@PostMapping
	String postcall(@RequestBody Account account) {
		if(account.equals(null))
			return "Invalid input";
		accountService.save(account);
		System.out.println("called");
		return "Account added successfully";
	}
	
	
}
