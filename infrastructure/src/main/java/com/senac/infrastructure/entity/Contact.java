package com.senac.infrastructure.entity;

import com.senac.infrastructure.enums.ContactType;
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
@Document(indexName = "contactindex")
public class Contact {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private ContactType contactType;

    @Field(type = FieldType.Text)
    private String number;
}
