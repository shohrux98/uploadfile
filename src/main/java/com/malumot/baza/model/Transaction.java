package com.malumot.baza.model;

public class Transaction {
    private Long id;

    private Double amount;
    private String reasons;
    private Long userId;

//    public Transaction(Double amount, String reasons, Long userId){
//        this.amount = amount;
//        this.reasons = reasons;
//        this.userId = userId;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getReasons() {
        return reasons;
    }

    public void setReasons(String reasons) {
        this.reasons = reasons;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
