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

import edu.utkarsh.springboot.dto.Lents;
import edu.utkarsh.springboot.dto.Response;
import edu.utkarsh.springboot.dto.User;
import edu.utkarsh.springboot.service.LentsService;


@CrossOrigin(origins = "*")
@RestController
public class LentController {

	@Autowired
	private LentsService lentsService;
	
	
	@PostMapping(value="/lent")
	protected ResponseEntity<Response<Lents>> addLent(@RequestBody Lents lents) {
		
		Lents lent = lentsService.addLent(lents);
		Response<Lents> response = new Response<>();
		if(lent!=null)
		{
			response.setMessage("Lent add sucessully");
			response.setData(lent);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		else
		{
			{
				response.setMessage("Lent not added sucessully");
				response.setData(lent);
				response.setStatusCode(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			}
		}
	}
	
	@PatchMapping("user/lent")
	private ResponseEntity<Response<User>> MapUserToLent(@RequestParam("uid") int uid,@RequestParam("lid") int lid) {
		User mapUserToLent = lentsService.MapUserToLent(uid,lid);
		Response<User> response = new Response<>();
		
		if(mapUserToLent != null)
		{
			response.setMessage("Lent is added");
			response.setData(mapUserToLent);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);	
		}else
		{  
			    response.setMessage("something went wrong");
				response.setData(mapUserToLent);
				response.setStatusCode(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			
		}
	}
	
	@DeleteMapping(value = "/lent")
	private ResponseEntity<Response<User>> deleteLent(@RequestParam("uid") int uid,@RequestParam("lid") int lid)
	{
		User user = lentsService.deleteLent(uid,lid);
		Response<User> response = new Response<>();
		
		if(user != null)
		{
			response.setMessage("Lent is deleted");
			response.setData(user);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);	
		}else
		{  
			    response.setMessage("something went wrong");
				response.setData(user);
				response.setStatusCode(HttpStatus.NOT_FOUND.value());
				return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
			
		}
	}
	
	@GetMapping(value = "/lent")
	protected ResponseEntity<Response<Lents>> findlentbyid(@RequestParam("lid") int lid) {
		
		Response<Lents> response = new Response<>();
		Lents lent = lentsService.findlentsById(lid);
		if(lent != null) {
		response.setData(lent);
		response.setMessage("spend found");
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<Response<Lents>>(response, HttpStatus.OK);
		}
		else
		{response.setData(lent);
		response.setMessage("spend not found");
		response.setStatusCode(HttpStatus.OK.value());
		return new ResponseEntity<Response<Lents>>(response, HttpStatus.OK);
		}
			
		}
	
	@CrossOrigin(origins = "*")
	@PatchMapping(value="/lents")
	protected ResponseEntity<Response<User>> updateUser(@RequestBody Lents lents,@RequestParam("uid") int uid, @RequestParam("lid") int lid) {
		Response<User> response = new Response<>();
		User user = lentsService.updateLent(lents,uid,lid);
		response.setMessage("Update Sucess");
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setData(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	
	
}
