package com.SportyShoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SportyShoes.model.UserTransactions;


public interface TransactionRepo extends JpaRepository<UserTransactions, Integer> {
	

}
