package com.senac.service;

import com.senac.domain.input.CompanyInp;
import com.senac.domain.input.Filter;
import com.senac.domain.input.RateInp;
import com.senac.domain.output.CacheExpirationOut;
import com.senac.domain.output.CompanyGetAllOut;
import com.senac.domain.output.CompanyOut;

import java.util.List;

public interface CompanyService {
    CompanyOut add(CompanyInp companyInp);
    CompanyOut update(CompanyInp companyInp);
    CompanyGetAllOut getAll(Filter filter);
    CompanyGetAllOut getByScroll(String scroll);
    void addRate(String companyId, String cache_code, RateInp rateInp);
    CacheExpirationOut generateRate(String companyId);
}
