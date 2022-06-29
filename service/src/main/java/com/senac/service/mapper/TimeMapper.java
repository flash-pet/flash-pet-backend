package com.senac.service.mapper;

import com.senac.domain.input.TimeInp;
import com.senac.domain.output.TimeOut;
import com.senac.infrastructure.entity.Time;

public class TimeMapper {
    private TimeMapper(){}
    public static final Time toEntity(TimeInp timeInp) {
        if(timeInp == null) return null;
        return Time.builder()
                .start(timeInp.getStart())
                .end(timeInp.getEnd())
                .build();
    }

    public static final TimeOut toOut(Time time) {
        if(time == null) return null;
        return TimeOut.builder()
                .start(time.getStart())
                .end(time.getEnd())
                .build();
    }
}
