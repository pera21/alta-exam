package com.exam.reponseModel;

public class ResponseLoan {
    
    private Long id;
    private Float total;
    private Long userId;

    public ResponseLoan(Long id, Float total, Long userId) {
        this.id = id;
        this.total = total;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
}
