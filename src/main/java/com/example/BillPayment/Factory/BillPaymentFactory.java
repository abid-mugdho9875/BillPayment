package com.example.BillPayment.Factory;

import com.example.BillPayment.Enum.BillPaymentOperator;
import com.example.BillPayment.Enum.BillPaymentType;
import com.example.BillPayment.Service.*;
import com.example.BillPayment.Service.Electricity.DESCOPaymentService;
import com.example.BillPayment.Service.Electricity.DPDCPaymentService;
import com.example.BillPayment.Service.Electricity.PDBPaymentService;
import com.example.BillPayment.Service.Water.WASAPaymentService;
import com.example.BillPayment.exception.beanNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component

public class BillPaymentFactory {

    @Lazy
    @Autowired
    private DESCOPaymentService descoPaymentService;
    @Lazy @Autowired
    private DPDCPaymentService dpdcPaymentService;
    @Lazy @Autowired
    private PDBPaymentService pdbPaymentService;
    @Lazy @Autowired
    private WASAPaymentService wasaPaymentService;


    public BILLPaymentService getInstance(BillPaymentType billType,
                                          BillPaymentOperator operator,
                                          String billId,
                                          String billerName, int billAmount) {


        if (billType == BillPaymentType.ELECTRICITY && operator == BillPaymentOperator.DESCO) {
            return this.descoPaymentService;
        } if (billType == BillPaymentType.ELECTRICITY && operator == BillPaymentOperator.DPDC) {
            return this.dpdcPaymentService;
        }
        if (billType == BillPaymentType.ELECTRICITY && operator == BillPaymentOperator.PDB) {
            return this.pdbPaymentService;

        }
        if (billType == BillPaymentType.WATER && operator == BillPaymentOperator.WASA) {
            return this.wasaPaymentService;
        }

        throw new beanNotFoundException(
                String.format("No Payment Service is declared for this payment-type:%s, operator:%s", billType, operator)
        );;

    }
}
