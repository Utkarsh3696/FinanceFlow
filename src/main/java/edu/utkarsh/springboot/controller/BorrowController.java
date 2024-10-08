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

import edu.utkarsh.springboot.dto.Borrow;
import edu.utkarsh.springboot.dto.Response;
import edu.utkarsh.springboot.dto.User;
import edu.utkarsh.springboot.service.BorrowService;

@CrossOrigin(value = "*")
@RestController
public class BorrowController {

	@Autowired
	private BorrowService borrowservice;

	@PostMapping(value = "/borrow")
	protected ResponseEntity<Response<Borrow>> addBorrow(@RequestBody Borrow borrow) {
		Borrow borrow2 = borrowservice.addBorrow(borrow);
		Response<Borrow> response = new Response<>();
		if (borrow2 != null) {
			response.setMessage("borrow record added");
			response.setData(borrow2);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<Response<Borrow>>(response, HttpStatus.OK);
		} else {
			response.setMessage("borrow record not added");
			response.setData(borrow2);
			response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			return new ResponseEntity<Response<Borrow>>(response, HttpStatus.NOT_FOUND);
		}

	}

	@PatchMapping(value = "/user/borrow")
	protected ResponseEntity<Response<User>> mapBorrowToUser(@RequestParam("uid") int uid,
			@RequestParam("bid") int bid) {
		User user = borrowservice.mapBorrowToUser(uid, bid);

		Response<User> response = new Response<>();
		if (user != null) {
			response.setMessage("borrow record added");
			response.setData(user);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.OK);
		} else {
			response.setMessage("borrow record not added");
			response.setData(user);
			response.setStatusCode(HttpStatus.NOT_ACCEPTABLE.value());
			return new ResponseEntity<Response<User>>(response, HttpStatus.NOT_FOUND);
		}
	}

	@PatchMapping(value = "/borrow")
	protected ResponseEntity<Response<User>> updateBorrow(@RequestBody Borrow borrow, @RequestParam("uid") int uid,
			@RequestParam("bid") int bid) {
		Response<User> response = new Response<>();
		User user = borrowservice.updateBorrow(borrow, uid, bid);
		response.setMessage("Update Sucess");
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setData(user);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@DeleteMapping(value = "/borrow")
	private ResponseEntity<Response<User>> deleteLent(@RequestParam("uid") int uid, @RequestParam("bid") int lid) {
		User user = borrowservice.deleteborrow(uid, lid);
		Response<User> response = new Response<>();

		if (user != null) {
			response.setMessage("borrow is deleted");
			response.setData(user);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setMessage("something went wrong");
			response.setData(user);
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

		}
	}

	@GetMapping(value="/borrow")
	protected ResponseEntity<Response<Borrow>> findBorrowByid(@RequestParam("bid") int bid) {
		Borrow borrow = borrowservice.findbyBId(bid);

		Response<Borrow> response = new Response<>();

		if (borrow != null) {
			response.setMessage("borrow is deleted");
			response.setData(borrow);
			response.setStatusCode(HttpStatus.OK.value());
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setMessage("something went wrong");
			response.setData(borrow);
			response.setStatusCode(HttpStatus.NOT_FOUND.value());
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);

		}

	}

}
