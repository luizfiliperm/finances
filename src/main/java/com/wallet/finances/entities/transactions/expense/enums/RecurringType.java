package com.wallet.finances.entities.transactions.expense.enums;

public enum RecurringType {
    MONTHLY(1),
    YEARLY(2);

    private int value;

    RecurringType(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
