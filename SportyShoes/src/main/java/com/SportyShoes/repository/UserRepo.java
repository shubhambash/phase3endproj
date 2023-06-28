package com.SportyShoes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.SportyShoes.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	
//	@Query("select u from user u where u.email = :email")
//	public boolean findByEmail(@Param("email") String email);
	
	public List<User> findByEmail(String email);


}
