package com.exam.reponseModel;

import java.util.List;

public class ReponseUser {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private List<ResponseLoan> loans;
    
    public ReponseUser(Long id, String email, String firstName, String lastName, List<ResponseLoan> loans) {
        this.id = id;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.loans = loans;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<ResponseLoan> getLoans() {
        return loans;
    }

    public void setLoans(List<ResponseLoan> loans) {
        this.loans = loans;
    }

    
}
