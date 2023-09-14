package com.example.BillPayment.Controller;

import com.example.BillPayment.DTO.BillPaymentRequest;
import com.example.BillPayment.DTO.BillPaymentResponse;
import com.example.BillPayment.Enum.BillPaymentOperator;
import com.example.BillPayment.Enum.BillPaymentType;
import com.example.BillPayment.Factory.BillPaymentFactory;
import com.example.BillPayment.Service.BILLPaymentService;
import com.example.BillPayment.exception.beanNotFoundException;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<String> billPayment(
            @RequestBody BillPaymentRequest request
    ) {
        try {
            validateInput(request); // Custom input validation

            // If input is valid, proceed with payment processing
            BILLPaymentService billPaymentService = this.billPaymentFactory.getInstance(
                    request.getBillType(), request.getOperator(), request.getBillId(),
                    request.getBillerName(), request.getBillAmount()
            );

            BillPaymentResponse response = billPaymentService.pay(request);

            return ResponseEntity.ok(response.getMessage());
        } catch (beanNotFoundException ex) {
            // Handle validation exceptions with a 400 Bad Request response
            return ResponseEntity.badRequest().body(ex.getMessage());
        } catch (Exception ex) {
            // Handle other exceptions here with a 500 Internal Server Error response
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error");
        }
    }

    private void validateInput(BillPaymentRequest request) {
        // Perform input validation here and throw BeanNotFoundException if input is invalid
        int billAmount = request.getBillAmount();
        if (billAmount <= 0) {
            throw new beanNotFoundException("Invalid input data. The 'billAmount' field must be a positive number.");
        }

        BillPaymentType billType = request.getBillType();
        System.out.println(billType);
        BillPaymentOperator operator = request.getOperator();
        System.out.println(operator);

        // Check if the provided billType is valid
        if (billType != BillPaymentType.ELECTRICITY && billType!= BillPaymentType.WATER) {
            throw new beanNotFoundException("Invalid 'billType'. Allowed values are ELECTRICITY and WATER.");
        }

        // Check if the provided operator is valid (you can add your operator enum values here)
        if (billType == BillPaymentType.ELECTRICITY) {
            if (operator != BillPaymentOperator.DESCO && operator != BillPaymentOperator.DPDC && operator != BillPaymentOperator.PDB) {
                throw new beanNotFoundException("Invalid 'operator' for ELECTRICITY bill.");
            }
        } else if (billType == BillPaymentType.WATER) {
            if (operator != BillPaymentOperator.WASA) {
                throw new beanNotFoundException("Invalid 'operator' for WATER bill.");
            }
        }
    }
}
