package com.example.BillPayment.Factory;

import com.example.BillPayment.Enum.BillPaymentOperator;
import com.example.BillPayment.Enum.BillPaymentType;
import com.example.BillPayment.Service.*;
import com.example.BillPayment.Service.Electricity.DESCOPaymentService;
import com.example.BillPayment.Service.Electricity.DPDCPaymentService;
import com.example.BillPayment.Service.Electricity.PDBPaymentService;
import com.example.BillPayment.Service.Water.WASAPaymentService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component

public class BillPaymentFactory {


    private final DESCOPaymentService descoPaymentService;
    private final DPDCPaymentService dpdcPaymentService;
    private  final  PDBPaymentService pdbPaymentService;
    private  final  WASAPaymentService wasaPaymentService;
    @Autowired
    public BillPaymentFactory(DESCOPaymentService descoPaymentService,
                              DPDCPaymentService dpdcPaymentService,
                              PDBPaymentService pdbPaymentService,
                              WASAPaymentService wasaPaymentService)
    {
        this.descoPaymentService = descoPaymentService;
        this.dpdcPaymentService = dpdcPaymentService;
        this.pdbPaymentService = pdbPaymentService;
        this.wasaPaymentService = wasaPaymentService;
    }



    public BILLPaymentService getInstance(BillPaymentType billType,
                                          BillPaymentOperator operator,
                                          String billId,
                                          String billerName, int billAmount) {


        if (billType == BillPaymentType.ELECTRICITY && operator == BillPaymentOperator.DESCO) {
            return this.descoPaymentService;
        } else if (billType == BillPaymentType.ELECTRICITY && operator == BillPaymentOperator.DPDC) {
            return this.dpdcPaymentService;
        }
        else if (billType == BillPaymentType.ELECTRICITY && operator == BillPaymentOperator.PDB) {
            return this.pdbPaymentService;

        }
        else if (billType == BillPaymentType.WATER && operator == BillPaymentOperator.WASA) {
            return this.wasaPaymentService;
        }

        return null;
    }
}
