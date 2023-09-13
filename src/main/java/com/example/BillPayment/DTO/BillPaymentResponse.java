package com.example.BillPayment.DTO;

public class BillPaymentResponse {
    private final String message;

    public BillPaymentResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
