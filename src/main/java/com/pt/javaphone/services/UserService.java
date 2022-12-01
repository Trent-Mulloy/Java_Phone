package com.pt.javaphone.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.pt.javaphone.models.LoginUser;
import com.pt.javaphone.models.User;
import com.pt.javaphone.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepo;
	
	// TO-DO: Write register and login methods!
    public User register(User newUser, User newUser2) {
        // TO-DO: Additional validations!
    	Optional<User> potentialUser = this.userRepo.findByEmail(newUser.getEmail());
    	if(potentialUser.isPresent()) {
    		//this means email is taken
    		newUser2.rejectValue("email", "email taken", "This email already exists.");
    	}
    	if(!newUser.getPassword().equals(newUser.getConfirm())) {
    		newUser2.rejectValue("confirm", "passwords dont match", "The confrim password must match the password");
    	}
    	if(newUser2.hasErrors()) {
    		return null;
    	}
    	else {
    		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
    		newUser.setPassword(hashed);
    		return this.userRepo.save(newUser);
    		

    	}
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
        // TO-DO: Additional validations!
    	System.out.println("Before");
    	Optional<User> potentialUser = this.userRepo.findByEmail(newLoginObject.getEmail());
    	System.out.println(potentialUser.isPresent());
    	if(!potentialUser.isPresent()) {
    		result.rejectValue("email", "user not found", "No User was found with this email.");
    	}
    	else {
	    	if(!BCrypt.checkpw(newLoginObject.getPassword(), potentialUser.get().getPassword())) {
	    		result.rejectValue("password", "Matches", "Invalid Password!");
	    		}
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	else {
    		return potentialUser.get();
    	}

    }
    public User one_user(Long id) {
		return this.userRepo.findById(id).orElse(null);
	}
}