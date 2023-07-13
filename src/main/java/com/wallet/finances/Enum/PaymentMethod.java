package com.wallet.finances.Enum;

public enum PaymentMethod {
    DEBIT(1),
    CREDIT(2);

    private int value;
    PaymentMethod(int value){
        this.value = value;
    }
}
