package com.exam.reponseModel;

import java.util.List;

public class ResponseGetLoans {
    private List<ResponseLoan> items;
    private Paging paging;
    
    public ResponseGetLoans(List<ResponseLoan> items, Paging paging) {
        this.items = items;
        this.paging = paging;
    }

    public List<ResponseLoan> getItems() {
        return items;
    }

    public void setItems(List<ResponseLoan> items) {
        this.items = items;
    }

    public Paging getPaging() {
        return paging;
    }

    public void setPaging(Paging paging) {
        this.paging = paging;
    }
    
}
