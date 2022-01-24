package com.exam.controller;

import java.util.ArrayList;
import java.util.List;

import com.exam.model.Loan;
import com.exam.reponseModel.Paging;
import com.exam.reponseModel.ResponseGetLoans;
import com.exam.reponseModel.ResponseLoan;
import com.exam.service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/loans")
public class LoanController {
    
    @Autowired
	private LoanService loanService;

    @GetMapping()
	public ResponseEntity<ResponseGetLoans> getAll(@RequestParam(required = false) Long userId, 
	@RequestParam Integer page, 
	@RequestParam Integer size) {
		try{
			Page<Loan> pageLoans;
			Pageable paging = PageRequest.of(page, size);
			if (userId == null){
				pageLoans = loanService.getAll(paging);
			}else{
				pageLoans = loanService.retrieveByUserId(userId, paging);
			}
			List<ResponseLoan> responseLoans = new ArrayList<ResponseLoan>();
			for (Loan loan : pageLoans.getContent()){
				ResponseLoan responseLoan = new ResponseLoan(loan.getId(), loan.getTotal(), loan.getUser().getId());
				responseLoans.add(responseLoan);
			}
			Paging responsePaging = new Paging(page, size, pageLoans.getTotalElements());
			return new ResponseEntity<ResponseGetLoans>(new ResponseGetLoans(responseLoans, responsePaging), HttpStatus.OK);
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("{id}")
	public ResponseEntity<Loan> retrieveById(@PathVariable(value = "id") Long loanId) {
		return new ResponseEntity<Loan>(loanService.retrieveById(loanId), HttpStatus.OK);
	}
	
	@PostMapping()
	public ResponseEntity<Loan> newLoan(@RequestBody Loan loan) {
		return new ResponseEntity<Loan>(loanService.newLoan(loan), HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteLoan(@PathVariable(value = "id") Long id) {	
		loanService.deleteLoan(id);	
	    return new ResponseEntity<String>("Loan deleted successfully!", HttpStatus.OK);
	}
}
