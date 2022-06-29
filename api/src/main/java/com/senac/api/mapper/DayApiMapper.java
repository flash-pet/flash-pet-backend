package com.senac.api.mapper;

import com.senac.api.dto.CompanyDays;
import com.senac.api.dto.Time;
import com.senac.domain.enums.DayTypeEn;
import com.senac.domain.input.TimeInp;
import com.senac.domain.output.TimeOut;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class DayApiMapper {
    private DayApiMapper(){}

    public static final Map<DayTypeEn, TimeInp> toDomain(Map<String, CompanyDays> daysRequest) {
      if(daysRequest == null) return null;
      final Map<DayTypeEn, TimeInp> days = new HashMap<>();

        for (var day: daysRequest.entrySet()) {
            days.put(DayTypeEn.valueOf(day.getKey().toUpperCase()), TimeApiMapper.toDomain(day.getValue().getTime()));
        }

        return days;
    }

    public static final Map<String, CompanyDays> toResponse(Map<DayTypeEn, TimeOut> days) {
        if(days == null) return null;
        return days.entrySet().stream()
                .collect(Collectors.toMap(entry -> entry.getKey().toString(),
                        entry -> convertToResponse(TimeApiMapper.toResponse(entry.getValue())))
                );
    }

    private static final CompanyDays convertToResponse(Time time) {
        final CompanyDays companyDays = new CompanyDays();
        companyDays.setTime(time);
        return companyDays;
    }
}
