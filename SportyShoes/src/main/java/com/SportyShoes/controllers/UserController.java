package com.SportyShoes.controllers;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SportyShoes.model.User;
import com.SportyShoes.model.UserDTO;
import com.SportyShoes.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;

	//register user
	
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "registration page";
    }
    
    
    @PostMapping("/register/save")
    public String registration(@RequestBody UserDTO userDto,
                               Model model){
    	
    	try {
    		
    		// test if user already exists
    		
    		
    		List<User> existingUser = userService.findUserByEmail(userDto.getEmail());   
   
            if(existingUser.size() > 0)
            {
            	return "User Already exists";
            }
            else
            {
                //save the data here
        		
                userService.saveUser(userDto);
            }
            

            
            return "registered";
		} catch (Exception e) {
			System.out.println(e);
		}
    		
    	return "error while saving in UserController";

    }
    
    

	//login user
    
    
    @GetMapping("/login")
    public String showLoginForm(Model model){
        // create model object to store form data
        UserDTO user = new UserDTO();
        model.addAttribute("user", user);
        return "Login Page";
    }
    
    
    
    @PostMapping("/login/save")
    public String login(@RequestBody UserDTO userDto,
                               Model model){
    	
    	try {
    		
    		// test if user exists or not 
    		List<User> validUser = userService.findUserByEmail(userDto.getEmail());   
            
    		// password matches
    		
    		if(validUser.size() == 0)
    		{
    			// redirect the user to the register page
    			
    			return "User is not registered yet";
    		}
    		
    		if(userDto.getPassword().compareTo(validUser.get(0).getPassword()) != 0)
    		{
    			// redirect the user to the login 
 
    			return "Incorrect User name or password";
    		}
    		
    		
    		// user is valid
    		// create a token and push 
    		
    		 String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
    	     StringBuilder salt = new StringBuilder();
    	     Random rnd = new Random();
    	     while (salt.length() < 18) { // length of the random string.
    	            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
    	            salt.append(SALTCHARS.charAt(index));
    	     }
    	     String saltStr = salt.toString();
    	     
    	     System.out.println(saltStr);
    	     
    	     //create a new user object
    	     
    	     User newUser = new User();
    	     newUser.setUser_id(userDto.getUser_id());
    	     newUser.setEmail(userDto.getEmail());
    	     newUser.setPassword(userDto.getPassword());
    	     newUser.setToken(saltStr);
    	     
    	     // adding token
    	     
    	     userService.updateUserToken(newUser, validUser.get(0).getUser_id());   
    	        
            return "Logged in";
		} catch (Exception e) {
			System.out.println(e);
		}
    		
    	return "error while saving in UserController";
    }
    
    
   
    
    
    
    
    
	
}
