package com.senac.domain.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Filter {
    private String serviceDescription;
    private String serviceType;
    private String priceCategory;
    private Double lat;
    private Double lon;
    private String day;
    private Integer rate;
}
