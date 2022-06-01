package com.senac.service.mapper;

import com.senac.domain.enums.DayTypeEn;
import com.senac.domain.input.TimeInp;
import com.senac.domain.output.TimeOut;
import com.senac.infrastructure.entity.Day;
import com.senac.infrastructure.enums.DayType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DayMapper {
    private DayMapper() {}

    public static final List<Day> toEntity(Map<DayTypeEn, TimeInp> days) {
       return days.entrySet().stream()
                .map(entry -> convertToEntity(entry))
                .collect(Collectors.toList());
    }

    public static final Map<DayTypeEn, TimeOut> toOut(List<Day> days) {
        return days.stream()
                .collect(Collectors.toMap(entry -> DayTypeEn.valueOf(entry.getType().toString().toUpperCase()),
                        entry -> TimeMapper.toOut(entry.getTime())));
    }

    private static final Day convertToEntity(Map.Entry<DayTypeEn, TimeInp> day) {
        return Day.builder()
                .type(DayType.valueOf(day.getKey().toString().toUpperCase()))
                .time(TimeMapper.toEntity(day.getValue()))
                .build();
    }
}
