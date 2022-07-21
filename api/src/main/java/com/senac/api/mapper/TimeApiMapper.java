package com.senac.api.mapper;

import com.senac.api.dto.Time;

public class TimeApiMapper {
    private TimeApiMapper(){}

    public static final com.senac.domain.entity.Time toDomain(Time time) {
        if(time == null) return null;
        return com.senac.domain.entity.Time.builder()
                .start(time.getStart())
                .end(time.getEnd())
                .build();
    }

    public static final Time toResponse(com.senac.domain.entity.Time time) {
        if(time == null) return null;
        final Time timeResponse = new Time();
        timeResponse.setStart(time.getStart());
        timeResponse.setEnd(time.getEnd());
        return timeResponse;
    }
}
