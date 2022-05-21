package com.senac.infrastructure.entity;

import com.senac.infrastructure.enums.PriceCategory;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "companyindex")
public class Company {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String address;

    @Field(type = FieldType.Integer)
    private Integer pageNumber;

    @Field(type = FieldType.Text)
    private PriceCategory priceCategory;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<ServiceC> services;
}
