package com.senac.infrastructure.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PriceCategory {
    LOW_000_300(0.00, 300.00),
    MIDDLE_300_500(300.00, 600.00),
    HIGH_600_UP(600.00, Double.MAX_VALUE);

    public Double min;
    public Double max;
}
