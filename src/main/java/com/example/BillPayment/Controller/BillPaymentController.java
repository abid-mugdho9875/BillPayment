package com.example.BillPayment.Controller;

import com.example.BillPayment.DTO.BillPaymentRequest;
import com.example.BillPayment.DTO.BillPaymentResponse;
import com.example.BillPayment.Factory.BillPaymentFactory;
import com.example.BillPayment.Service.BILLPaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BillPaymentController {
    private final BillPaymentFactory billPaymentFactory;

    public BillPaymentController(BillPaymentFactory billPaymentFactory) {
        this.billPaymentFactory = billPaymentFactory;
    }
    @PostMapping("/bill-payment")
    public ResponseEntity<BillPaymentResponse> billPayment(
            @RequestBody BillPaymentRequest request
    ) {
        BILLPaymentService billPaymentService = this.billPaymentFactory.getInstance(
                request.getBillType(), request.getOperator(), request.getBillId(),
                request.getBillerName(),request.getBillAmount()
        );

        BillPaymentResponse response = billPaymentService.pay(request);

        return ResponseEntity.ok(response);
    }
}
