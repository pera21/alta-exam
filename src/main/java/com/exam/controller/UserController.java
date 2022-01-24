package com.exam.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Loan;
import com.exam.model.User;
import com.exam.reponseModel.ReponseUser;
import com.exam.reponseModel.ResponseLoan;
import com.exam.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping()
	public List<User> getAll() {
		return userService.getAll();
	}

	@GetMapping("{id}")
	public ResponseEntity<ReponseUser> retrieveById(@PathVariable(value = "id") Long userId) {
		User user = userService.retrieveById(userId);
		List<ResponseLoan> responseLoans = new ArrayList<ResponseLoan>();
		for (Loan loan : user.getLoans()){
			ResponseLoan responseLoan = new ResponseLoan(loan.getId(), loan.getTotal(), userId);
			responseLoans.add(responseLoan);
		}
		return new ResponseEntity<ReponseUser>(new ReponseUser(user.getId(), user.getEmail(), user.getFirstName(), user.getLastName(), responseLoans), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<User> newUser(@RequestBody User user) {
		return new ResponseEntity<User>(userService.newUser(user), HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Long id) {	
		userService.deleteUser(id);	
	    return new ResponseEntity<String>("User deleted successfully!", HttpStatus.OK);
	}

}
