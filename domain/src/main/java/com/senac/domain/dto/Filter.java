package com.senac.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Filter {
    private String serviceDescription;
    private List<String> serviceType;
    private List<Object> priceCategory;
    private Double lat;
    private Double lon;
    private List<String> day;
    private Integer rate;
    private Integer rateFinal;
}
