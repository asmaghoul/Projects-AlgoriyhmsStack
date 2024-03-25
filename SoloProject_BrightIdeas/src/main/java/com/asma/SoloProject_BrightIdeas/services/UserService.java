package com.asma.SoloProject_BrightIdeas.services;


import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.asma.SoloProject_BrightIdeas.models.Idea;
import com.asma.SoloProject_BrightIdeas.models.LoginUser;
import com.asma.SoloProject_BrightIdeas.models.User;
import com.asma.SoloProject_BrightIdeas.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepo;
	
    public User register(User newUser, BindingResult result) {
       
        
        // Reject if email is taken (present in database)
    	if(userRepo.findByEmail(newUser.getEmail()).isPresent()) {
    		result.rejectValue("email", "unique", "this email already exist !");
    	}
        // Reject if password doesn't match confirmation
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("password", "unique", "password error !");
        }
        // Return null if result has errors
    if(result.hasErrors()) {
    	return null;
    }else {
    	// Hash and set password, save user to database
    	String hashedPW = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    	newUser.setPassword(hashedPW);
    	return userRepo.save(newUser);
    	
    }
        
    }
    
    public User login(LoginUser newLoginObject, BindingResult result) {
 
	// Find user in the DB by email
    	Optional<User> potentialUser = userRepo.findByEmail(newLoginObject.getEmail());
    	// Reject if NOT present
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "unique", "this email does not exist!");
    		return null;
    	}
    	User user = potentialUser.get();
    		 // Reject if BCrypt password match fails
        	if(!BCrypt.checkpw(newLoginObject.getPassword(),user.getPassword())) {
        	    result.rejectValue("password", "Matches", "Invalid Password!");
        	}
    	
  // Return null if result has errors
    	if(result.hasErrors()) {
    		return null;
    	}else {
    		 // Otherwise, return the user object
    		return user;
    	}
  	
}
    
    public User findUser(Long id) {
    	Optional<User> user = userRepo.findById(id);
    	if(! user.isPresent()) {
    		return null;
    	}else {
    		return user.get();
    	}
    }
 // return liked user idea
    public List<Idea> likedIdeas(Long userId){
    	return userRepo.findLikedIdeasByUserId(userId);
    }
    
  //List of ideas created by the user
   
    public List<Idea> findIdeasCreatedByUser(Long userId) {
        return userRepo.findIdeasCreatedByUser(userId);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
