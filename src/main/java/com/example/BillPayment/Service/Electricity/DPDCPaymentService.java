package com.example.BillPayment.Service.Electricity;

import com.example.BillPayment.DTO.BillPaymentRequest;
import com.example.BillPayment.DTO.BillPaymentResponse;
import com.example.BillPayment.Service.BILLPaymentService;
import org.springframework.stereotype.Service;

@Service

public class DPDCPaymentService implements BILLPaymentService {
    @Override
    public BillPaymentResponse pay(BillPaymentRequest request) {

        String billerName = request.getBillerName();
        String billerId = request.getBillId();
        int billAmount = request.getBillAmount();
        if(billAmount < 500) {
            return new BillPaymentResponse("Please pay more than 500");
        }
        else {
            return new BillPaymentResponse("Successful DPDC payment " + billAmount + " by "+billerName);
        }


    }
}
