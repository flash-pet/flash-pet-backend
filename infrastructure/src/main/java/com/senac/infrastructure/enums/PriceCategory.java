package com.senac.infrastructure.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum PriceCategory {
    LOW_100_300(100.00, 300.00),
    LOW_MAX_100_1000(100.00, 1000000.00);

    public Double min;
    public Double max;
}
