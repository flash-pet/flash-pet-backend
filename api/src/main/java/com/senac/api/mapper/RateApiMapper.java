//package com.senac.api.mapper;
//
//import com.senac.api.dto.Rate;
//import com.senac.domain.output.RateOut;
//
//import java.util.stream.Collectors;
//
//public class RateApiMapper {
//    private RateApiMapper(){}
//
//    public static final Rate toResponse(RateOut rate) {
//        if(rate == null) return null;
//        final Rate rateResponse = new Rate();
//        rateResponse.setIndividualRate(rate.getRates().stream().map(IndividualRateApiMapper::toResponse).collect(Collectors.toList()));
//        rateResponse.setAvg(rate.getAvg());
//        return rateResponse;
//    }
//}
