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
@Document(indexName = "ownerindex")
public class Owner {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String username;

    @Field(type = FieldType.Text)
    private String password;

    @Field(type = FieldType.Text)
    private String email;
}