package com.SportyShoes.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SportyShoes.model.User;
import com.SportyShoes.model.UserDTO;
import com.SportyShoes.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	public List<User> findUserByEmail(String email)
	{
		List<User> user = userRepo.findByEmail(email);
		return user;
	}
	
	
	
	
    public void saveUser(UserDTO userDto) {
    	
    	try {
            User user = new User();
            
            user.setEmail(userDto.getEmail());
            
            // encrypt the password using spring security
            // user.setPassword(passwordEncoder.encode(userDto.getPassword()));
            
            user.setPassword(userDto.getPassword());
            
            userRepo.save(user);
            
            
		} catch (Exception e) {
			System.out.println("Error while registering user data in UserService");
		}
              
    }
    
    public void updateUserToken(User newUser, int id)
    {
    	try {
        	userRepo.deleteById(id);
        	userRepo.save(newUser);        	
		} catch (Exception e) {
			System.out.println("Error in updating the user token in UserService" + e);
		}
    	
    	
    }
    
    
	
}
