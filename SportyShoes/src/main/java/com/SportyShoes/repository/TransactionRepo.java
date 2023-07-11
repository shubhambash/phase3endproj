package com.SportyShoes.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SportyShoes.model.UserTransactions;


public interface TransactionRepo extends JpaRepository<UserTransactions, Integer> {

	List<UserTransactions> findAllByCategory(String category);

	List<UserTransactions> findAllByAppointmentTime(String appointmentTime);

}
