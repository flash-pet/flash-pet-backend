package com.senac.infrastructure.entity;

import com.senac.infrastructure.enums.DayType;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "dayindex")
public class Day {

    @Field(type = FieldType.Text)
    private DayType type;

    @Field(type = FieldType.Object)
    private Time time;
}
