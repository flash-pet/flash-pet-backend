package com.senac.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "time_index")
public class Time {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String start;

    @Field(type = FieldType.Text)
    private String end;
}
