package com.senac.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(indexName = "company_index")
public class Company {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Text)
    private String address;

    @JsonIgnore
    @GeoPointField
    private GeoPoint location;

    @Field(type = FieldType.Object, includeInParent = true)
    private Owner owner;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Contact> contact;

    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Service> services;

    @Field(type = FieldType.Object, includeInParent = true)
    private Rate rate;

    @JsonIgnore
    @Field(type = FieldType.Nested, includeInParent = true)
    private List<Day> days;

    @Field(type = FieldType.Text)
    private String logo;

    @Field(type = FieldType.Text, includeInParent = true)
    private List<String> carrosel;
}
