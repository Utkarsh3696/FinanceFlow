package edu.utkarsh.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import edu.utkarsh.springboot.dto.Response;
import edu.utkarsh.springboot.dto.User;
import edu.utkarsh.springboot.service.UserService;

@CrossOrigin(origins = "*")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping(value = "/users")
	protected ResponseEntity<Response<User>> addUser(@RequestBody User user) {
		
		user.setPassword(userService.encodePass(user.getPassword()));
		User user2 = userService.addUser(user);
	
		Response<User> response = new Response<>();
		if (user2 != null) {
			response.setMessage("user is  added");
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setData(user2);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {

			response.setMessage("user is not added");
			response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			response.setData(user2);
			return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	
	@PatchMapping(value="/user")
	protected ResponseEntity<Response<User>> updateUser(@RequestBody User user,@RequestParam("uid") int uid) {
		
		
		User user2 = userService.UpdateUser(user,uid);
	
		Response<User> response = new Response<>();
		if (user2 != null) {
			response.setMessage("User is Updated");
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setData(user2);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {

			response.setMessage("user is not updated");
			response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			response.setData(user2);
			return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
		}

	}
	
	
	@GetMapping(value="users/{id}")
	protected ResponseEntity<Response<User>> findUserById(@PathVariable("id") int id) {
		User user2 = userService.findUserByID(id);
		Response<User> response = new Response<>();
		if (user2 != null) {
			response.setMessage("user found");
			response.setStatusCode(HttpStatus.FOUND.value());
			response.setData(user2);
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {

			response.setMessage("user not found");
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			response.setData(user2);
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}

	}
	
	@GetMapping(value="users")
	protected ResponseEntity<Response<List<User>>> findAllUser() {
		
		List<User> allUsers = userService.findAllUsers();
		Response<List<User>> response = new Response<>();
		if(allUsers!=null && !(allUsers.isEmpty()))
		{
			response.setMessage("users found");
			response.setData(allUsers);
			response.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<>(response, HttpStatus.FOUND);
		}
		else
		{
			response.setMessage("users not found");
			response.setData(allUsers);
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping(value="users/{id}")
	protected ResponseEntity<Response<List<User>>> deleteUserById(@PathVariable("id") int id) {
		User user = userService.findUserByID(id);
		List<User> deleteUserById = userService.deleteUserById(id);
		Response<List<User>> response = new Response<>();
		if(user!=null)
		{
			response.setMessage("user is delete sucessully");
			response.setData(deleteUserById);
			response.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else
		{
			response.setMessage("user not found");
			response.setData(deleteUserById);
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			
		}
	}
	
	
	
	@PostMapping(value="user/login")
	protected ResponseEntity<Response<User>> findUserByEmailandPassword(@RequestBody User user) {
	
		User user2 = userService.findUserByEmail(user.getEmail());
		Response<User> response = new Response<>();
		if(user2 == null)
		{
			response.setMessage("Your Are Not a User of FinaceFlow Application, Go For Sigup");
			response.setData(user2);
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else {
			if(userService.mathcpass(user.getPassword(),user2.getPassword()))
			{response.setMessage("Login Sucessfully");
			response.setData(user2);
			response.setStatusCode(HttpStatus.FOUND.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
			}else {
				response.setMessage("Your Password is Incorrect");
				response.setData(user2);
				response.setStatusCode(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
		}
		
	}
	
	
	@PatchMapping(value="/users/spend")
	protected ResponseEntity<Response<User>> mapSpendToUser(@RequestParam("uid") int uid, @RequestParam("sid") int sid) {
		Response<User> response = new Response<>();
		User user = userService.mapSpendToUser(uid,sid);
		response.setMessage("spend map sucessfull");
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setData(user);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}
	
	
	@PatchMapping(value="/users/income")
	protected ResponseEntity<Response<User>> mapincomedToUser(@RequestParam("uid") int uid, @RequestParam("iid") int iid) {
		Response<User> response = new Response<>();
		User user = userService.maIncomeToUser(uid,iid);
		response.setMessage("map success");
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setData(user);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
		
	}
	
	
	
	
	
	
	
}
