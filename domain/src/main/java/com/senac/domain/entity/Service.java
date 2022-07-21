package com.senac.domain.entity;


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
@Document(indexName = "service_index")
public class Service {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private String type;

    @Field(type = FieldType.Double)
    private Double price;
}
