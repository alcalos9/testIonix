package cl.ionix.test.test.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.ionix.test.test.entity.User;
import cl.ionix.test.test.model.AllUserOutput;
import cl.ionix.test.test.model.EmailRequest;
import cl.ionix.test.test.model.UserCreateOuput;
import cl.ionix.test.test.model.UserEmailOutput;
import cl.ionix.test.test.model.UserInput;
import cl.ionix.test.test.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value = "/ejemplo", method = RequestMethod.POST)
	public String helloWorld() {
		return "Hello World User";
	}
	
	@RequestMapping(value = "/createUser", method = RequestMethod.PUT)
	public UserCreateOuput createUser(@RequestBody UserInput user) {
		
		UserCreateOuput result = new UserCreateOuput();
		
		try{
			User userRep = new User();
			userRep.setName(user.getName());
			userRep.setUsername(user.getUsername());
			userRep.setEmail(user.getEmail());
			userRep.setPhone(user.getPhone());
			
			if(userRepository.save(userRep) != null) {
				result.setResult(true);
				result.setMessage("saved");
			}else {
				result.setResult(false);
				result.setMessage("no se logró registrar el usuario");
			}
			
			return result;
			
		}catch(Exception e){
			result.setResult(false);
			result.setMessage("error");
			return result;
		}
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public AllUserOutput allUser() {
		AllUserOutput response = new AllUserOutput();
		boolean result = false;
		String message = "";
		Iterable<User> users = null;
		
		try {
			users = userRepository.findAll();
			
			if(users != null) {
				result = true;
				message = "ok";
			}else {
				result = true;
				message = "not found";
			}
			
		}catch (Exception e) {
			result = false;
			message = "error";
			users = null;
		}
		finally {
			response.setResult(result);
			response.setMessage(message);
			response.setUsers(users);
			return response;
		}
		
	}
	
	@SuppressWarnings("finally")
	@RequestMapping(value = "/userByEmail", method = RequestMethod.GET)
	public UserEmailOutput userByEmail(@RequestBody EmailRequest email) {
		UserEmailOutput response = new UserEmailOutput();
		List<User> usersFind = new ArrayList<User>();
		
		boolean result = false;
		String message = "";
		
		try {
			Iterable<User> users = userRepository.findAll();
			if(users != null) {
				for (User user : users) {
					if(user.getEmail().equalsIgnoreCase(email.getEmail()))
						usersFind.add(user);
				}
				result = true;
				message = "ok";
				
				if(usersFind.size() == 0)
					message = "not found";
				
			}else {
				result = false;
				message = "problem services";
			}
			
		}catch(Exception e) {
			result = false;
			message = "error";
			usersFind = null;
		}
		finally {
			response.setResult(result);
			response.setMessage(message);
			response.setUsers(usersFind);
			return response;
		}
	}

}
