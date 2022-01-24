package com.exam.service;

import java.util.Optional;

import com.exam.exception.ResourceNotFoundException;
import com.exam.model.Loan;
import com.exam.repository.LoanRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public Page<Loan> getAll(Pageable paging) {
        return loanRepository.findAll(paging);
    }

    @Override
    public Page<Loan> retrieveByUserId(Long user_id, Pageable paging) {
        return loanRepository.findByUserId(user_id, paging);
    }

    @Override
    public Loan newLoan(Loan loan) {
       return loanRepository.save(loan);
    }

    @Override
    public Loan retrieveById(Long loanId) {
        Optional<Loan> loan = loanRepository.findById(loanId);
        if (loan.isPresent()){
            return loan.get();
        }else{
            throw new ResourceNotFoundException("Loan", "Id", loanId);
        }
    }

    @Override
    public void deleteLoan(Long loanId) {
        Optional<Loan> loan = loanRepository.findById(loanId);
        if (loan.isPresent()){
           loanRepository.deleteById(loanId);
        }else{
            throw new ResourceNotFoundException("Loan", "Id", loanId);
        }
    }    
    
}
