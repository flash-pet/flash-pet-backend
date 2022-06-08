package com.senac.infrastructure.entity;


import com.senac.infrastructure.enums.ServiceType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Map;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "service_index")
public class ServiceC {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String description;

    @Field(type = FieldType.Text)
    private ServiceType type;

    @Field(type = FieldType.Double)
    private Double price;
}
