package com.exam.service;

import com.exam.model.Loan;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface LoanService {

    Page<Loan> getAll(Pageable paging);
    Page<Loan> retrieveByUserId(Long user_id, Pageable paging);
    Loan newLoan(Loan loan);
    Loan retrieveById(Long loanId);
    void deleteLoan(Long loanId);
    
}
