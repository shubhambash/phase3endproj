package com.SportyShoes.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.model.TransactionDTO;
import com.SportyShoes.model.UserTransactions;
import com.SportyShoes.repository.TransactionRepo;

@Service
public class TransactionService {

	@Autowired
	TransactionRepo tranRepo;
	
	
	// save the transaction
	
	public String saveTransaction(TransactionDTO transDto)
	{
		
		try {
			
			UserTransactions userTrans = new UserTransactions();
			
			
			userTrans.setUser_id(transDto.getUser_id());
			userTrans.setEmail(transDto.getEmail());
			userTrans.setCategory_name(transDto.getCategory_name());
			userTrans.setProduct_name(transDto.getProduct_name());
			userTrans.setAppointmentTime(transDto.getAppointmentTime());
			
			tranRepo.save(userTrans);	
			
			
			return "user transaction saved";
			
		} catch (Exception e) {
			
			
			
		}
		
		
		return "unable to save";
		
	}
	
	
}
