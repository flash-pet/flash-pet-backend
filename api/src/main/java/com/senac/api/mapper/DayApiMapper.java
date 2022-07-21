package com.senac.api.mapper;

import com.senac.api.dto.CompanyDays;
import com.senac.domain.entity.Day;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DayApiMapper {
    private DayApiMapper(){}

    public static final List<Day> toDomain(Map<String, CompanyDays> daysRequest) {
      if(daysRequest == null) return null;
      final List<Day> days = new ArrayList<>();

        for (var day: daysRequest.entrySet()) {
            days.add(new Day(day.getKey(), TimeApiMapper.toDomain(day.getValue().getTime())));
        }

        return days;
    }

    public static final Map<String, CompanyDays> toResponse(List<Day> days) {
        if(days == null) return null;
        return days.stream().collect(Collectors.toMap(day -> day.getType(),
                day -> {
                    var time = TimeApiMapper.toResponse(day.getTime());
                    CompanyDays companyDays = new CompanyDays();
                    companyDays.setTime(time);
                    return companyDays;
                }));
    }

}
