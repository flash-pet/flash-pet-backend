package com.senac.domain.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@AllArgsConstructor
@Getter
@Setter
public class CompanyGetAllOut {
    private String scrollId;
    private List<CompanyOut> companies;
}
