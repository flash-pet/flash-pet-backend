package com.senac.api.mapper;

import com.senac.api.dto.Time;
import com.senac.domain.input.TimeInp;
import com.senac.domain.output.TimeOut;

public class TimeApiMapper {
    private TimeApiMapper(){}

    public static final TimeInp toDomain(Time time) {
        if(time == null) return null;
        return TimeInp.builder()
                .start(time.getStart())
                .end(time.getEnd())
                .build();
    }

    public static final Time toResponse(TimeOut time) {
        if(time == null) return null;
        final Time timeResponse = new Time();
        timeResponse.setStart(time.getStart());
        timeResponse.setEnd(time.getEnd());
        return timeResponse;
    }
}
