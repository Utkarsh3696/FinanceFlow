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

import edu.utkarsh.springboot.dto.Income;
import edu.utkarsh.springboot.dto.Response;
import edu.utkarsh.springboot.dto.User;
import edu.utkarsh.springboot.service.IncomeService;

@CrossOrigin("*")
@RestController
public class IncomeController {

	@Autowired
	IncomeService incomeService;
	
	

	@PostMapping(value="/income")
	protected ResponseEntity<Response<Income>> addIncome(@RequestBody Income income) {
		
		Income income2 = incomeService.addIncome(income);
		Response<Income> response = new Response<>();
		response.setMessage("icome added sucessfull");
		response.setData(income2);
		response.setStatusCode(HttpStatus.CREATED.value());
		
		return new ResponseEntity<Response<Income>>(response, HttpStatus.CREATED);
		
	}
	
	@DeleteMapping(value="/income")
	protected ResponseEntity<Response<User>> deleteIncome(@RequestParam("uid") int uid, @RequestParam("iid") int iid) {
		Response<User> response = new Response<>();
		User user = incomeService.deleteIncome(uid,iid);
		response.setMessage("delete Sucess");
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setData(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/income")
	protected ResponseEntity<Response<Income>> findIncome(@RequestParam("iid") int iid) {
		Response<Income> response = new Response<>();
		 Income income = incomeService.findIncome(iid);
		if(income != null)
		{
			response.setMessage("Income found");
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setData(income);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else
		{
			response.setMessage("Income not found");
			response.setStatusCode(HttpStatus.CREATED.value());
			response.setData(income);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		
	}
	
	@PatchMapping(value="/income")
	protected ResponseEntity<Response<User>> updateUser(@RequestBody Income income,@RequestParam("uid") int uid, @RequestParam("iid") int iid) {
		Response<User> response = new Response<>();
		User user = incomeService.updateIncome(income,uid,iid);
		response.setMessage("Update Sucess");
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setData(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	
}
