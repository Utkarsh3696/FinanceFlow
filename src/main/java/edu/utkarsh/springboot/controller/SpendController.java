package edu.utkarsh.springboot.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import edu.utkarsh.springboot.dto.Response;
import edu.utkarsh.springboot.dto.Spend;
import edu.utkarsh.springboot.dto.User;
import edu.utkarsh.springboot.service.SpendService;

@CrossOrigin(origins = "*")
@RestController
public class SpendController {

	@Autowired
	private SpendService spendService;
	
	
	@PostMapping(value="/spends")
	protected ResponseEntity<Response<Spend>> addSpend(@RequestBody Spend spend) {
		Spend spend2 = spendService.addSpend(spend);
		Response<Spend> response = new Response<>();
		response.setMessage("Spend added sucessfull");
		response.setData(spend2);
		response.setStatusCode(HttpStatus.CREATED.value());
		return  new ResponseEntity<Response<Spend>>(response, HttpStatus.OK) ;
	}
	
	@DeleteMapping(value="/spend")
	protected ResponseEntity<Response<User>> deleteSpend(@RequestParam("uid") int uid,@RequestParam("sid")int sid) {
		
		User user = spendService.deleteSpend(uid,sid);
		Response<User> response = new Response<>();
		
		response.setData(user);
		response.setMessage("Deleted sucessfull");
		response.setStatusCode(HttpStatus.OK.value());
		
		return new ResponseEntity<Response<User>>(response, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/spend")
	protected ResponseEntity<Response<Spend>> findSpendbyid(@RequestParam("sid") int sid) {
		
		Response<Spend> response = new Response<>();
		Spend spend = spendService.findSpendById(sid);
		if(spend != null) {
		response.setData(spend);
		response.setMessage("spend found");
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<Response<Spend>>(response, HttpStatus.OK);
		}
		else
		{response.setData(spend);
		response.setMessage("spend not found");
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<Response<Spend>>(response, HttpStatus.OK);
		}
			
			
		}
	
	@PatchMapping(value="/spend")
	protected ResponseEntity<Response<User>> updateUser(@RequestBody Spend spend,@RequestParam("uid") int uid, @RequestParam("sid") int sid) {
		Response<User> response = new Response<>();
		User user = spendService.updateIncome(spend,uid,sid);
		response.setMessage("Update Sucess");
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setData(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
		
	}
	
	
	

