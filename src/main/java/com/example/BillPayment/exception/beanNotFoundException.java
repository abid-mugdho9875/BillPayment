package com.example.BillPayment.exception;

import com.example.BillPayment.DTO.BillPaymentRequest;
import com.example.BillPayment.DTO.BillPaymentResponse;
import com.example.BillPayment.Service.BILLPaymentService;

public class beanNotFoundException implements BILLPaymentService {



    @Override
    public BillPaymentResponse pay(BillPaymentRequest request) {
        return new BillPaymentResponse(message);
    }
}
