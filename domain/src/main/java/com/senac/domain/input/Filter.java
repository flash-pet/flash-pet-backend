package com.senac.domain.input;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Filter {
    private Integer pageNumber;
    private String serviceDescription;
    private String priceCategory;
}
