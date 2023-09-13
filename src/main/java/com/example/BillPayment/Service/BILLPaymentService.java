package com.example.BillPayment.Service;

import com.example.BillPayment.DTO.BillPaymentRequest;
import com.example.BillPayment.DTO.BillPaymentResponse;

public interface BILLPaymentService {

    BillPaymentResponse pay(BillPaymentRequest request);

}
