package com.senac.infrastructure.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "rateindex")
public class Rate {

    @Id
    private String id;

    @Field(type = FieldType.Integer)
    private Integer value;

    @Field(type = FieldType.Integer)
    private String description;

    @Field(type = FieldType.Date)
    private LocalDate date;

}
