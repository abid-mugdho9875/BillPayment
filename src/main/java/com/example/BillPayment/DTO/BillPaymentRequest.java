package com.example.BillPayment.DTO;

import com.example.BillPayment.Enum.BillPaymentOperator;
import com.example.BillPayment.Enum.BillPaymentType;

public class BillPaymentRequest {

    private BillPaymentType billType;
    private BillPaymentOperator operator;
    private String billId;
    private String billerName;
    private  int billAmount;

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public void setBillerName(String billerName) {
        this.billerName = billerName;
    }



    public String getBillId() {
        return billId;
    }

    public String getBillerName() {
        return billerName;
    }


    public void setBillAmount(int billAmount) {
        this.billAmount = billAmount;
    }
    public int getBillAmount() {
        return billAmount;
    }
    public void setBillType(BillPaymentType billType) {
        this.billType = billType;
    }

    public void setOperator(BillPaymentOperator operator) {
        this.operator = operator;
    }


    public BillPaymentType getBillType() {
        return billType;
    }

    public BillPaymentOperator getOperator() {
        return operator;
    }


}
