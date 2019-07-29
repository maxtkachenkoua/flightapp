package com.bluerbn.flightapp.constants;

public enum Discount {
    AMOUNT_OFF_10_PERCENTS(.1d),
    AMOUNT_OFF_20_PERCENTS(.2d),
    AMOUNT_OFF_30_PERCENTS(.3d),
    AMOUNT_OFF_40_PERCENTS(.4d),
    AMOUNT_OFF_50_PERCENTS(.5d);

    private final Double amountOff;

    Discount(Double amountOff) {
        this.amountOff = amountOff;
    }

    public Double getAmountOff() {
        return amountOff;
    }
}
