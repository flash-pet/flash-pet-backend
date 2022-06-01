package com.senac.infrastructure.entity;

import com.senac.infrastructure.enums.DayType;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;
import java.util.Map;

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

    @GeoPointField
    private GeoPoint location;

    @Field(type = FieldType.Object)
    private Owner owner;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Contact> contacts;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<ServiceC> services;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Rate>  rates;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Day> days;
}
