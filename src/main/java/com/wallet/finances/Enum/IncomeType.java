package com.wallet.finances.Enum;

public enum IncomeType {
    MONTHLY(1),
    SPORADIC(2);
    private int value;
    IncomeType(int value){this.value = value;}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
