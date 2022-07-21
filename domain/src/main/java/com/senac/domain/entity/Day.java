package com.senac.domain.entity;

import lombok.*;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "day_index")
public class Day {

    @Field(type = FieldType.Text)
    private String type;

    @Field(type = FieldType.Object)
    private Time time;
}
