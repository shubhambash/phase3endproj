package com.SportyShoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SportyShoes.model.TransactionDTO;
import com.SportyShoes.model.User;
import com.SportyShoes.service.TransactionService;
import com.SportyShoes.service.UserService;

@RestController
public class UserTransController {

	@Autowired
	UserService userService;
	
	@Autowired
	TransactionService transService;
	
	@PostMapping("/buy")
	public String buy(@RequestParam(name="T") String token, @RequestParam(name="M") String email,
			@RequestBody TransactionDTO dto)
	{
		
		
		
		if(!userService.isUserLoggedIn(token , email))
		{
			// redirect user to login page
			
			return "please login first";
		}
		
		// save the transaction
		
		transService.saveTransaction(dto);
		
		
		return "Bought !";
	}
	
}
