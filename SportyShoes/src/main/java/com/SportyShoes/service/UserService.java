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
	
	
	// user by their email
	public List<User> findUserByEmail(String email)
	{
		List<User> user = userRepo.findByEmail(email);
		return user;
	}
	
	
	
	//register user
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
    
    //update token
    public void updateUserToken(User newUser, int id)
    {
    	try {
        	userRepo.deleteById(id);
        	userRepo.save(newUser);        	
		} catch (Exception e) {
			System.out.println("Error in updating the user token in UserService" + e);
		}
    	
    	
    }
    
    //middle ware that checks whether user is logged in or not
    
    public boolean isUserLoggedIn(String token, String email)
    {
   
    	List<User> user = userRepo.findByEmail(email);
    	System.out.println(email + " " + user + " " +  user.size());
    	if(user.size() > 0)
    	{
    		System.out.println("user exists");
    		if(user.get(0).getToken().compareTo(token) == 0)
    		{
    			System.out.println("user token success");
    			return true;
    		}
    	}
    	
    	return false;
    }
    
    
	
}
